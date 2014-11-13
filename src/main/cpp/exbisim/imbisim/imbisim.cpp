/**
 * imbisim.cpp - Internal memory DAG online bisimulation.
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
#include <map>
#include <set>
#include <stack>
#include <utility>
#include "common/format.hpp"
#include "common/records.hpp"
#include "common/treetag.hpp"
#include "lib/array.hpp"
#include "lib/entrypoint.hpp"
#include "imbisim.hpp"

void bisim_dag(lib::BinaryReader<uint>& in,
               lib::BinaryWriter<PartitionNodePair>& out)
{
    uint nodes = in.read();
    lib::Array<uint> nodeBlock(nodes);
    std::map<std::pair<uint, std::set<uint>>, uint> pds;
    for (uint i = 0; i < nodes; ++i)
    {
        uint label = in.read();
        std::set<uint> children;

        uint edges = in.read();
        for (uint j = 0; j < edges; ++j)
        {
            uint child = in.read();
            if (child >= i)
            {
                throw "Invalid child edge, child does not appear before node.";
            }
            children.insert(nodeBlock[child]);
        }

        std::pair<uint, std::set<uint>> key = make_pair(label, children);
        if (pds.count(key) == 0)
        {
            pds[key] = (uint) pds.size();
        }

        uint partitionBlock = pds[key];
        nodeBlock[i] = partitionBlock;

        PartitionNodePair pair = { partitionBlock, i };
        out << pair;
    }
}

void bisim_tree(lib::BinaryReader<ubyte>& in,
                lib::BinaryWriter<PartitionNodePair>& out)
{
    std::stack<uint> parents;
    std::map<std::pair<uint, uint>, uint> pds;

    uint i = 0;
    do
    {
        ubyte tag = in.read();
        if (tag == TreeTag::OPEN)
        {
            uint label = in.read<uint>();
            uint parent = (!parents.empty()) ? parents.top() : 0;
            std::pair<uint, uint> key = std::make_pair(label, parent);

            if (pds.count(key) == 0)
            {
                pds[key] = (uint) pds.size() + 1;
            }

            uint partitionBlock = pds[key];
            parents.push(partitionBlock);

            PartitionNodePair pair = { partitionBlock, i };
            out << pair;
        }
        else if (tag == TreeTag::CLOSE)
        {
            if (parents.empty())
            {
                throw "Invalid node close; no node opened.";
            }
            parents.pop();
        }
        else
        {
            throw "Invalid sequence in tree.";
        }
    }
    while (!parents.empty());
}

void entrypoint(int argc, const char* argv[],
                boost::program_options::variables_map& variables)
{
    lib::BinaryWriter<PartitionNodePair> out(lib::get_argument<std::string>(variables, "out"));
    lib::BinaryReader<uint> in(lib::get_argument<std::string>(variables, "in"));
    uint format = in.read();
    if (format == Format::DAG)
    {
        bisim_dag(in, out);
    }
    else if (format == Format::TREE)
    {
        lib::BinaryReader<ubyte> in(lib::get_argument<std::string>(variables, "in"));
        bisim_tree(in, out);
    }
    else
    {
        throw "Invalid format.";
    }
}

int main(int argc, const char* argv[])
{
    using namespace boost::program_options;
    static const char message[] =
        "Perform internal memory (backward) bisimulation on trees and dags\n"
        "  imbisim --help\n"
        "  imbisim [--in] arg [--out] arg\n\n";

    options_description description("Allowed options");
    description.add_options()
            ("help,h", "produce help")
            ("in,i", value<std::string>(),
                "the file to read the graph from (in tree or dag format)")
            ("out,o", value<std::string>(),
                "the file to write the partition to");

    positional_options_description positionals;
    positionals.add("in", 1);
    positionals.add("out", 1);

    return lib::entrypoint(entrypoint, argc, argv, message, description, positionals);
}