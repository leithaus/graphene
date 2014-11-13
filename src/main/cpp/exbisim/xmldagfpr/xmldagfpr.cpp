/**
 * xmldagfpr.cpp - Generate dagfp graphs from xml documents.
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
#include "common/format.hpp"
#include "lib/entrypoint.hpp"
#include "lib/stxxl/compare.hpp"
#include "xmldagfpr.hpp"

/**
 * pd: Note: Note: platform dependent header; needed for open() function to open
 * files. We need this function for a small 'fix' for large file support within
 * libxml2. Other platforms don't need io.h but might need unistd.h for close().
 */
#include <io.h>
#include <fcntl.h>

template<class Label> void process_attributes(xmlTextReaderPtr reader,
                                              Label& label, std::ofstream* log,
                                              stxxl::VECTOR_GENERATOR<uint>::result& parents,
                                              stxxl::VECTOR_GENERATOR<uint>::result& labels,
                                              stxxl::VECTOR_GENERATOR<Edge>::result& edges)
{
    int attribute = xmlTextReaderMoveToFirstAttribute(reader);

    while (attribute == 1)
    {
        labels.push_back(label_id(reader, label, true, log));
        Edge edge = { parents.back(), labels.size() - 1 };
        edges.push_back(edge);
        attribute = xmlTextReaderMoveToNextAttribute(reader);
    }
    xmlTextReaderMoveToElement(reader);
}

template<class Label> void process_node(xmlTextReaderPtr reader,
                                        Label& label, std::ofstream* log,
                                        stxxl::VECTOR_GENERATOR<uint>::result& parents,
                                        stxxl::VECTOR_GENERATOR<uint>::result& labels,
                                        stxxl::VECTOR_GENERATOR<Edge>::result& edges)
{
    int type = xmlTextReaderNodeType(reader);
    if (type == OPEN_ELEMENT)
    {
        labels.push_back(label_id(reader, label, false, log));
        if (!parents.empty())
        {
            Edge edge = { parents.back(), labels.size() - 1 };
            edges.push_back(edge);
        }
        parents.push_back(labels.size() - 1);
        process_attributes(reader, label, log, parents, labels, edges);

        if (xmlTextReaderIsEmptyElement(reader) == 1)
        {
            parents.pop_back();
        }
    }
    else if (type == CLOSE_ELEMENT)
    {
        parents.pop_back();
    }
}

void read_xml(xmlTextReaderPtr reader, std::ofstream* log, bool hashing,
              stxxl::VECTOR_GENERATOR<uint>::result& labels,
              stxxl::VECTOR_GENERATOR<Edge>::result& edges)
{
    xmlTextReaderSetErrorHandler(reader, error_handler, 0);
    stxxl::VECTOR_GENERATOR<uint>::result parents;

    int node = 0;
    uint rank = 0;
    if (hashing)
    {
        HashLabel labelHash;
        while ((node = xmlTextReaderRead(reader)) == 1)
        {
            process_node(reader, labelHash, log, parents, labels, edges);
        }
    }
    else
    {
        std::map<XmlString, uint> labelMap;
        while ((node = xmlTextReaderRead(reader)) == 1)
        {
            process_node(reader, labelMap, log, parents, labels, edges);
        }
    }
}

void write_dagfpr(const stxxl::VECTOR_GENERATOR<uint>::result& labels,
                  const stxxl::VECTOR_GENERATOR<Edge>::result& edges,
                  lib::BinaryWriter<uint>& out)
{
    out << Format::DAGFP << (uint) labels.size();

    stxxl::VECTOR_GENERATOR<uint>::result sizes;
    auto eit = edges.cbegin(), eend = edges.cend();
    for (uint node = 0, end = labels.size(); node != end; ++node)
    {
        uint count = 0;
        while ((eit != eend) && (eit->from == node))
        {
            ++count;
            ++eit;
        }
        sizes.push_back(count);
    }

    uint node = 0;
    eit = edges.cbegin();
    auto sit = sizes.cbegin(), send = sizes.cend();
    for (auto it = labels.cbegin(), end = labels.cend(); it != end; ++it, ++node, ++sit)
    {
        out << *it << *sit;
        for (uint i = 0, count = *sit; i != count; ++i, ++eit)
        {
            out << eit->to;
        }
    }
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


    stxxl::VECTOR_GENERATOR<uint>::result nodes;
    stxxl::VECTOR_GENERATOR<Edge>::result edges;

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
        read_xml(reader, &file, hashing, nodes, edges);
    }
    else
    {
        read_xml(reader, 0, hashing, nodes, edges);
    }
    
    xmlFreeTextReader(reader);
    close(fd);
    lib::BinaryWriter<uint> out(lib::get_argument<std::string>(variables, "out"));
    stxxl::sort(edges.begin(), edges.end(), lib::stxxl::less<Edge>(), MEMORY_BLOCK);
    write_dagfpr(nodes, edges, out);
}

int main(int argc, const char* argv[])
{
    using namespace boost::program_options;
    static const char message[] =
        "Convert an xml tree document into a graph in dagfp format; reverse edges\n"
        "  xmltree --help\n"
        "  xmltree [--in] arg [--out] arg [[--label] arg] [--hash]\n\n";

    options_description description("Allowed options");
    description.add_options()
            ("help,h", "produce help")
            ("in,i", value<std::string>(),
                "the file to read the XML document from")
            ("out,o", value<std::string>(),
                "the file to write the graph to (in dagfp format)")
            ("label,l", value<std::string>(),
                    "optional file to write the assigned labels to; this file "
                    "will contain one entry (label identifier, tag name) for "
                    "every node in the xml tree when hashing is used; it will "
                    "contain one entry (label identifier, tag name) for every "
                    "label when hashing is not used")
            ("hash", "this flag enables hashing to convert XML tag names "
                    "into label identifiers; by default every unique tag name"
                    "is converted to a unique label, but this mapping can "
                    "become to large for graphs with many different tag names");

    positional_options_description positionals;
    positionals.add("in", 1);
    positionals.add("out", 1);
    positionals.add("label", 1);

    return lib::entrypoint(entrypoint, argc, argv, message, description, positionals);
}