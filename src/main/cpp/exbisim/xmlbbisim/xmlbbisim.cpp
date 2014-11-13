/**
 * xmlbbisim.cpp - Backward bisimulate xml documents.
 *
 * Copyright (c) 2011 Jelle Hellings <exbisim@jhellings.nl>.
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY JELLE HELLINGS ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO
 * EVENT SHALL THE FOUNDATION OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
#include <fstream>
#include "lib/entrypoint.hpp"
#include "lib/stxxl/buffer.hpp"
#include "xmlbbisim.hpp"

/**
 * pd: Note: Note: platform dependent header; needed for open() function to open
 * files. We need this function for a small 'fix' for large file support within
 * libxml2. Other platforms don't need io.h but might need unistd.h for close().
 */
#include <io.h>
#include <fcntl.h>

template<class Label> void process_attributes(xmlTextReaderPtr reader,
                                              Label& label, std::ofstream* log, uint rank,
                                              stxxl::VECTOR_GENERATOR<uint>::result& numNodes,
                                              stxxl::VECTOR_GENERATOR<XmlNode>::result& nodes,
                                              stxxl::VECTOR_GENERATOR<XmlEdge>::result& edges)
{
    int attribute = xmlTextReaderMoveToFirstAttribute(reader);
    if (numNodes.size() == rank)
    {
        numNodes.push_back(0);
    }

    while (attribute == 1)
    {
        XmlNode node = {rank, numNodes[rank], label_id(reader, label, true, log)};
        XmlEdge edge = {rank - 1, numNodes[rank - 1] - 1, numNodes[rank]};
        ++numNodes[rank];

        nodes.push_back(node);
        edges.push_back(edge);

        attribute = xmlTextReaderMoveToNextAttribute(reader);
    }
    xmlTextReaderMoveToElement(reader);
}

template<class Label> void process_node(xmlTextReaderPtr reader,
                                        Label& label, std::ofstream* log, uint& rank,
                                        stxxl::VECTOR_GENERATOR<uint>::result& numNodes,
                                        stxxl::VECTOR_GENERATOR<XmlNode>::result& nodes,
                                        stxxl::VECTOR_GENERATOR<XmlEdge>::result& edges)
{
    int type = xmlTextReaderNodeType(reader);
    if (type == OPEN_ELEMENT)
    {
        if (numNodes.size() == rank)
        {
            numNodes.push_back(0);
        }

        XmlNode node = {rank, numNodes[rank], label_id(reader, label, false, log)};
        if (rank != 0)
        {
            XmlEdge edge = {rank - 1, numNodes[rank - 1] - 1, numNodes[rank]};
            edges.push_back(edge);
        }
        ++numNodes[rank];
        nodes.push_back(node);

        ++rank;
        process_attributes(reader, label, log, rank, numNodes, nodes, edges);

        if (xmlTextReaderIsEmptyElement(reader) == 1)
        {
            --rank;
        }
    }
    else if (type == CLOSE_ELEMENT)
    {
        --rank;
    }
}

void read_xml(xmlTextReaderPtr reader, std::ofstream* log, bool hashing,
              stxxl::VECTOR_GENERATOR<uint>::result& numNodes,
              stxxl::VECTOR_GENERATOR<XmlNode>::result& nodes,
              stxxl::VECTOR_GENERATOR<XmlEdge>::result& edges)
{
    xmlTextReaderSetErrorHandler(reader, error_handler, 0);

    int node = 0;
    uint rank = 0;
    if (hashing)
    {
        HashLabel labelHash;
        while ((node = xmlTextReaderRead(reader)) == 1)
        {
            process_node(reader, labelHash, log, rank, numNodes, nodes, edges);
        }
    }
    else
    {
        std::map<XmlString, uint> labelMap;
        while ((node = xmlTextReaderRead(reader)) == 1)
        {
            process_node(reader, labelMap, log, rank, numNodes, nodes, edges);
        }
    }
}

uint tree_bbisim(const stxxl::VECTOR_GENERATOR<uint>::result& numNodes,
                 const stxxl::VECTOR_GENERATOR<XmlNode>::result& nodes,
                 const stxxl::VECTOR_GENERATOR<XmlEdge>::result& edges,
                 lib::BinaryWriter<XmlPartitionNodePair>& out)
{
    lib::stxxl::Buffer<XmlAnnotateNode> localNodes;
    lib::stxxl::Buffer<XmlAnnotateEdge> localEdges;
    PriorityQueue Q(MEMORY_BLOCK, MEMORY_BLOCK);

    XmlNodePartitionBlock rootParent = { { 0, 0 }, 0 };
    Q.push(rootParent);
    uint partitions = 0;
    uint rank = 0;

    auto nit = nodes.cbegin(), nend = nodes.cend();
    auto eit = edges.cbegin(), eend = edges.cend();
    for (auto it = numNodes.cbegin(), numEnd = numNodes.cend(); it != numEnd; ++it, ++rank)
    {
        for (uint i = 0, num = *it; i != num; ++i, ++nit)
        {
            uint parentBlock = Q.top().partition_block;
            Q.pop();

            const XmlNode& node = *nit;
            XmlAnnotateNode annotatedNode = { parentBlock, node.label,
                                              node.identifier.index };

            while ((eit != eend) && (eit->from == node.identifier))
            {
                XmlAnnotateEdge edge = { annotatedNode, eit->to };
                localEdges.push_back(edge);
                ++eit;
            }
            localNodes.push_back(annotatedNode);
        }

        localNodes.sort(lib::stxxl::less<XmlAnnotateNode>());
        localEdges.sort(lib::stxxl::less<XmlAnnotateEdge>());

        uint j = 0, edges = localEdges.size();
        for (uint i = 0, end = localNodes.size(); i != end; ++partitions)
        {
            uint parentBlock = localNodes[i].parent_block;
            uint label = localNodes[i].label;

            do
            {
                const XmlAnnotateNode& node = localNodes[i];
                XmlPartitionNodePair pair = { partitions, { rank, node.index } };
                out << pair;

                for (; (j != edges) && (localEdges[j].from == node); ++j)
                {
                    XmlNodePartitionBlock message = { { rank + 1, localEdges[j].to }, partitions };
                    Q.push(message);
                }
                ++i;
            } while ((i != end) && (localNodes[i].parent_block == parentBlock) &&
                                   (localNodes[i].label == label));
        }

        localNodes.clear();
        localEdges.clear();
    }

    return partitions;
}

void entrypoint(int argc, const char* argv[],
                boost::program_options::variables_map& variables)
{
    std::string file = lib::get_argument<std::string>(variables, "in");
    int fd = open(file.c_str(), O_RDONLY); // Note: for large file size problems.
    xmlTextReaderPtr reader = xmlReaderForFd(fd, file.c_str(), NULL, XML_PARSE_HUGE);
    if (reader == 0)
    {
        throw "Could not open file for XML reading.";
    }

    stxxl::VECTOR_GENERATOR<uint>::result numNodes;
    stxxl::VECTOR_GENERATOR<XmlNode>::result nodes;
    stxxl::VECTOR_GENERATOR<XmlEdge>::result edges;

    bool hashing = variables.count("hash") != 0;
    if (variables.count("label") != 0)
    {
        std::ofstream file(variables["label"].as<std::string>(),
                            std::ios_base::out | std::ios_base::trunc);

        if (!file.good())
        {
            throw "Could not open label file.";
        }

        file.exceptions(std::ios::badbit);
        read_xml(reader, &file, hashing, numNodes, nodes, edges);
    }
    else
    {
        read_xml(reader, 0, hashing, numNodes, nodes, edges);
    }
    
    xmlFreeTextReader(reader);
    close(fd);
    lib::BinaryWriter<XmlPartitionNodePair> out(lib::get_argument<std::string>(variables, "out"));
    stxxl::sort(nodes.begin(), nodes.end(), lib::stxxl::less<XmlNode>(), MEMORY_BLOCK);
    stxxl::sort(edges.begin(), edges.end(), lib::stxxl::less<XmlEdge>(), MEMORY_BLOCK);
    uint partitions = tree_bbisim(numNodes, nodes, edges, out);

    if (variables.count("stats") != 0)
    {
        stxxl::stats& stats = *stxxl::stats::get_instance();
        std::cout << "Nodes: " << nodes.size() << "\n"
                     "Partitions: " << partitions << "\n"
                     "Tree depth: " << numNodes.size() << "\n"
                     "(STXXL) Reads: " << stats.get_reads() << "\n"
                     "(STXXL) Writes: " << stats.get_writes() << "\n"
                     "(STXXL) Reads (bytes): " << stats.get_read_volume() << "\n"
                     "(STXXL) Writes (bytes: " << stats.get_written_volume() << "\n";
    }
}

int main(int argc, const char* argv[])
{
    using namespace boost::program_options;
    static const char message[] =
        "Backward bisimulate an xml tree document\n"
        "  xmlbbisim --help\n"
        "  xmlbbisim [--in] arg [--out] arg [[--label] arg] [--hash] [--stats]\n\n";

    options_description description("Allowed options");
    description.add_options()
            ("help,h", "produce help")
            ("in,i", value<std::string>(),
                "the file to read the XML document from")
            ("out,o", value<std::string>(),
                "the file to write the partition to")
            ("label,l", value<std::string>(),
                    "optional file to write the assigned labels to; this file "
                    "will contain one entry (label identifier, tag name) for "
                    "every node in the xml tree when hashing is used; it will "
                    "contain one entry (label identifier, tag name) for every "
                    "label when hashing is not used")
            ("hash", "this flag enables hashing to convert XML tag names "
                    "into label identifiers; by default every unique tag name"
                    "is converted to a unique label, but this mapping can "
                    "become to large for graphs with many different tag names")
            ("stats,s", "flag to enable the collection and writing of "
                "statistics");

    positional_options_description positionals;
    positionals.add("in", 1);
    positionals.add("out", 1);
    positionals.add("label", 1);

    return lib::entrypoint(entrypoint, argc, argv, message, description, positionals);
}