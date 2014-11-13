/**
 * graphstat.cpp - Graph statistics. 
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
#include <iostream>
#include "common/format.hpp"
#include "common/treetag.hpp"
#include "lib/array.hpp"
#include "lib/entrypoint.hpp"
#include "lib/stxxl/compare.hpp"
#include "graphstat.hpp"

uint label_count_s(stxxl::VECTOR_GENERATOR<uint>::result& labels)
{
    uint count = 0;
    stxxl::sort(labels.begin(), labels.end(), lib::stxxl::less<uint>(), MEMORY_BLOCK);
    if (!labels.empty())
    {
        count = 1;
        uint label = *labels.cbegin();
        for (auto it = labels.cbegin(), end = labels.cend(); it != end; ++it)
        {
            if (label != *it)
            {
                ++count;
                label = *it;
            }
        }
    }
    return count;
}

void stat_tree(stxxl::VECTOR_GENERATOR<uint>::result& labels, lib::BinaryReader<ubyte>& in)
{
    uint nodes = 0;
    uint depth = 0;
    uint parents = 0;
    do
    {
        ubyte tag = in.read();
        if (tag == TreeTag::OPEN)
        {
            labels.push_back(in.read<uint>());
            ++parents;
            ++nodes;
            depth = std::max(parents, depth);
        }
        else if (tag == TreeTag::CLOSE)
        {
            if (parents == 0)
            {
                throw "Invalid node close; no node opened.";
            }
            --parents;
        }
        else
        {
            throw "Invalid sequence in tree.";
        }
    }
    while (parents != 0);

    std::cout << "Nodes: " << nodes << "\n"
                 "Edges: " << (nodes - 1) << "\n"
                 "Maximum depth: " << depth << "\n"
                 "Labels: " << label_count_s(labels) << "\n";
}

void stat_dag(stxxl::VECTOR_GENERATOR<uint>::result& labels, lib::BinaryReader<uint>& in)
{
    uint nodes = in.read();
    uint edges = 0;
    for (uint i = 0; i < nodes; ++i)
    {
        labels.push_back(in.read());
        uint childEdges = in.read();
        for (uint j = 0; j < childEdges; ++j)
        {
            if (in.read() >= i)
            {
                throw "Invalid child edge, child does not appear before node.";
            }
        }
        edges += childEdges;
    }

    std::cout << "Nodes: " << nodes << "\n"
                 "Edges: " << edges << "\n"
                 "Labels: " << label_count_s(labels) << "\n";
}

void stat_dagfp(stxxl::VECTOR_GENERATOR<uint>::result& labels, lib::BinaryReader<uint>& in)
{
    uint nodes = in.read();
    uint edges = 0;
    for (uint i = 0; i < nodes; ++i)
    {
        labels.push_back(in.read());
        uint parentEdges = in.read();
        for (uint j = 0; j < parentEdges; ++j)
        {
            if (in.read() <= i)
            {
                throw "Invalid parent edge, parent does appear before node.";
            }
        }
        edges += parentEdges;
    }

    std::cout << "Nodes: " << nodes << "\n"
                 "Edges: " << edges << "\n"
                 "Labels: " << label_count_s(labels) << "\n";
}

void stat_dagfps(stxxl::VECTOR_GENERATOR<uint>::result& labels,
                 lib::BinaryReader<uint>& in)
{
    uint groups = 0;
    uint nodes = 0;
    uint ranks = 0;
    uint edges = 0;
    uint partitionNodes = 0;

    uint prevLabel = 0;
    uint partitions = in.read();
    for (uint i = 0; i < partitions; ++i)
    {
        uint groupNodes = in.read();
        uint rank = in.read();
        uint label = in.read();
        partitionNodes = std::max(groupNodes, partitionNodes);

        if ((i == 0) || (ranks != rank) || (prevLabel != label))
        {
            ++groups;
            ranks = rank;

            if (prevLabel != label)
            {
                labels.push_back(label);
                prevLabel = label;
            }
        }

        for (uint j = 0; j < groupNodes; ++j, ++nodes)
        {
            uint parentEdges = in.read();
            for (uint k = 0; k < parentEdges; ++k)
            {
                if (in.read() <= nodes)
                {
                    throw "Invalid parent edge, parent does not appear after node.";
                }
            }
            edges += parentEdges;
        }
    }

    std::cout << "Nodes: " << nodes << "\n"
                 "Edges: " << edges << "\n"
                 "Partitions: " << partitions << "\n"
                 "Largest partition: " << partitionNodes << "\n"
                 "Rank, label: " << groups << "\n"
                 "Rank (max): " << ranks << "\n"
                 "Labels: " << label_count_s(labels) << "\n";
}

void entrypoint(int argc, const char* argv[],
                boost::program_options::variables_map& variables)
{
    lib::BinaryReader<uint> in(lib::get_argument<std::string>(variables, "in"));
    uint format = in.read();

    stxxl::VECTOR_GENERATOR<uint>::result labels;
    if (format == Format::DAG)
    {
        stat_dag(labels, in);
    }
    else if (format == Format::DAGFP)
    {
        stat_dagfp(labels, in);
    }
    else if (format == Format::DAGFPS)
    {
        stat_dagfps(labels, in);
    }
    else if (format == Format::TREE)
    {
        lib::BinaryReader<ubyte> in(lib::get_argument<std::string>(variables, "in"));
        stat_tree(labels, in);
    }
    else
    {
        throw "Input format is not recognized.";
    }
}

int main(int argc, const char* argv[])
{
    using namespace boost::program_options;
    static const char message[] =
        "Calculate graph statistics of dag or tree\n"
        "Statistics are written to standard output\n"
        "  graphstat --help\n"
        "  graphstat [--in] arg\n\n";

    options_description description("Allowed options");
    description.add_options()
            ("help,h", "produce help")
            ("in,i", value<std::string>(),
                "the file to read the graph from (in tree, dag, dagfp or dagfps format)");

    positional_options_description positionals;
    positionals.add("in", 1);

    return lib::entrypoint(entrypoint, argc, argv, message, description, positionals);
}