/**
 * vis.cpp - Convert trees and DAGs to Graphviz dot format.
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
#include <stack>
#include "common/format.hpp"
#include "common/records.hpp"
#include "common/treetag.hpp"
#include "lib/array.hpp"
#include "lib/entrypoint.hpp"
#include "vis.hpp"

void vis_dag(lib::BinaryReader<uint>& in, std::ofstream& out)
{
    out << "digraph {\n";
    uint nodes = in.read();
    for (uint i = 0; i < nodes; ++i)
    {
        vis_node(i, in.read(), out);
        uint children = in.read();
        for (uint j = 0; j < children; ++j)
        {
            uint child = in.read();
            if (child >= i)
            {
                throw "Invalid child edge, child does not appear before node.";
            }
            vis_edge(i, child, out);
        }
    }
    out << "}";
}

void vis_dagfp(lib::BinaryReader<uint>& in, std::ofstream& out)
{
    out << "digraph {\n";
    uint nodes = in.read();
    stxxl::VECTOR_GENERATOR<Edge>::result edges;

    for (uint i = 0; i < nodes; ++i)
    {
        vis_node(i, in.read(), out);
        uint parents = in.read();
        for (uint j = 0; j < parents; ++j)
        {
            uint parent = in.read();
            if (parent <= i)
            {
                throw "Invalid parent edge, parent does not appear after node.";
            }

            Edge edge = { parent, i };
            edges.push_back(edge);
        }
    }
    vis_edge_file(edges, out);
    out << "}";
}

void vis_dagfps(lib::BinaryReader<uint>& in, std::ofstream& out)
{
    out << "digraph {\n";
    uint groups = in.read();
    stxxl::VECTOR_GENERATOR<Edge>::result edges;

    uint node = 0;
    for (uint i = 0; i < groups; ++i)
    {
        uint nodes = in.read();
        uint rank = in.read();
        uint label = in.read();

        for (uint j = 0; j < nodes; ++j, ++node)
        {
            vis_node(node, label, out);
            uint parents = in.read();
            for (uint k = 0; k < parents; ++k)
            {
                uint parent = in.read();
                if (parent <= node)
                {
                    throw "Invalid parent edge, parent does not appear after node.";
                }

                Edge edge = { parent, node };
                edges.push_back(edge);
            }
        }
    }
    vis_edge_file(edges, out);
    out << "}";
}

inline void vis_edge(uint from, uint to, std::ofstream& out)
{
    out << 'N' << from << "->N" << to << '\n';
}

inline void vis_edge_file(const stxxl::VECTOR_GENERATOR<Edge>::result& edges, std::ofstream& out)
{
    for (auto it = edges.cbegin(), end = edges.cend(); it != end; ++it)
    {
        vis_edge(it->from, it->to, out);
    }
}

inline void vis_node(uint id, uint label, std::ofstream& out)
{
    out << 'N' << id << "[label=\"" << label << "\"]\n";
}

void vis_tree(lib::BinaryReader<ubyte>& in, std::ofstream& out)
{
    out << "digraph {\n";
    std::stack<uint> parents;
    uint i = 0;
    do
    {
        ubyte tag = in.read();
        if (tag == TreeTag::OPEN)
        {
            vis_node(i, in.read<uint>(), out);
            if (!parents.empty())
            {
                vis_edge(parents.top(), i, out);
            }
            parents.push(i++);
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
    out << "}";
}

void entrypoint(int argc, const char* argv[],
                boost::program_options::variables_map& variables)
{
    lib::BinaryReader<uint> in(lib::get_argument<std::string>(variables, "in"));
    std::ofstream out(lib::get_argument<std::string>(variables, "out"),
            std::ios_base::binary | std::ios_base::out | std::ios_base::trunc);
    out.exceptions(std::ios::badbit | std::ios::failbit);

    uint format = in.read();
    out << std::hex;
    if (format == Format::DAG)
    {
        vis_dag(in, out);
    }
    else if (format == Format::DAGFP)
    {
        vis_dagfp(in, out);
    }
    else if (format == Format::DAGFPS)
    {
        vis_dagfps(in, out);
    }
    else if (format == Format::TREE)
    {
        lib::BinaryReader<ubyte> in(lib::get_argument<std::string>(variables, "in"));
        vis_tree(in, out);
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
        "Convert a tree or a dag into Graphviz dot format for visualization\n"
        "output\n"
        "  vis --help\n"
        "  vis [--in] arg [--out] arg\n\n";

    options_description description("Allowed options");
    description.add_options()
            ("help,h", "produce help")
            ("in,i", value<std::string>(),
                "the file to read the graph from (in tree, dag, dagfp or dagfps format)")
            ("out,o", value<std::string>(),
                "the file to write the graph to (in Graphviz dot format)");

    positional_options_description positionals;
    positionals.add("in", 1);
    positionals.add("out", 1);

    return lib::entrypoint(entrypoint, argc, argv, message, description, positionals);
}