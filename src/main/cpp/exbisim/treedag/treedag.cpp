/**
 * treedag.cpp - Convert trees to DAGs.
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
#include "common/format.hpp"
#include "common/treetag.hpp"
#include "lib/array.hpp"
#include "lib/entrypoint.hpp"
#include "lib/stxxl/compare.hpp"
#include "treedag.hpp"

void num_children_node(const uint nodes,
                       const stxxl::VECTOR_GENERATOR<Edge>::result& edges,
                       stxxl::VECTOR_GENERATOR<uint>::result& sizes)
{
    uint node = 0;
    for (auto it = edges.cbegin(), end = edges.cend(); node != nodes; ++node)
    {
        uint count = 0;
        for (; (it != end) && (it->from == node); ++it)
        {
            ++it;
        }
        sizes.push_back(count);
    }
}

void read_tree(stxxl::VECTOR_GENERATOR<Node>::result& nodes,
               stxxl::VECTOR_GENERATOR<Edge>::result& edges,
               lib::BinaryReader<ubyte>& in)
{
    stxxl::VECTOR_GENERATOR<uint>::result parents;

    uint i = 0;
    do
    {
        ubyte tag = in.read();
        if (tag == TreeTag::OPEN)
        {
            uint label = in.read<uint>();

            Node node = { i, label };
            nodes.push_back(node);
            if (!parents.empty())
            {
                Edge edge = { parents.back(), i };
                edges.push_back(edge);
            }
            parents.push_back(i++);
        }
        else if (tag == TreeTag::CLOSE)
        {
            if (parents.empty())
            {
                throw "Invalid node close; no node opened.";
            }
            parents.pop_back();
        }
        else
        {
            throw "Invalid sequence in tree.";
        }
    }
    while (!parents.empty());
}

void tree_dag(stxxl::VECTOR_GENERATOR<Node>::result& nodes,
              stxxl::VECTOR_GENERATOR<Edge>::result& edges)
{
    uint max = nodes.size() - 1;
    for (auto it = nodes.begin(), end = nodes.end(); it != end; ++it)
    {
        it->identifier = max - it->identifier;
    }
    for (auto it = edges.begin(), end = edges.end(); it != end; ++it)
    {
        it->from = max - it->from;
        it->to = max - it->to;
    }
    stxxl::sort(nodes.begin(), nodes.end(), lib::stxxl::less<Node>(), MEMORY_BLOCK);
    stxxl::sort(edges.begin(), edges.end(), lib::stxxl::less<Edge>(), MEMORY_BLOCK);
}

void tree_dag_r(stxxl::VECTOR_GENERATOR<Node>::result& nodes,
                stxxl::VECTOR_GENERATOR<Edge>::result& edges)
{
    for (auto it = edges.begin(), end = edges.end(); it != end; ++it)
    {
        std::swap(it->from, it->to);
    }
    stxxl::sort(edges.begin(), edges.end(), lib::stxxl::less<Edge>(), MEMORY_BLOCK);    
}

void write_dag(const stxxl::VECTOR_GENERATOR<Node>::result& nodes,
               const stxxl::VECTOR_GENERATOR<Edge>::result& edges,
               const stxxl::VECTOR_GENERATOR<uint>::result& sizes,
               lib::BinaryWriter<uint>& out)
{
    out << Format::DAG << (uint) nodes.size();

    uint node = 0;
    auto eit = edges.cbegin(), eend = edges.cend();
    auto sit = sizes.cbegin(), send = sizes.cend();
    for (auto it = nodes.cbegin(), end = nodes.cend(); it != end; ++it, ++node, ++sit)
    {
        uint size = *sit;
        out << it->label << size;

        for (uint i = 0; i < size; ++i, ++eit)
        {
            out << eit->to;
        }
    }
}

void entrypoint(int argc, const char* argv[],
                boost::program_options::variables_map& variables)
{
    stxxl::VECTOR_GENERATOR<Node>::result nodes;
    stxxl::VECTOR_GENERATOR<Edge>::result edges;
    stxxl::VECTOR_GENERATOR<uint>::result sizes;

    lib::BinaryWriter<uint> out(lib::get_argument<std::string>(variables, "out"));
    lib::BinaryReader<ubyte> in(lib::get_argument<std::string>(variables, "in"));

    uint format = in.read<uint>();
    if (format != Format::TREE)
    {
        throw "Input format is not recognized.";
    }
    read_tree(nodes, edges, in);

    bool reverse = variables.count("reverse") != 0;
    if (reverse)
    {
        tree_dag_r(nodes, edges);
    }
    else
    {
        tree_dag(nodes, edges);
    }

    num_children_node(nodes.size(), edges, sizes);
    write_dag(nodes, edges, sizes, out);
}

int main(int argc, const char* argv[])
{
    using namespace boost::program_options;
    static const char message[] =
        "Convert a tree to a dag; optionally one can reverse edges in the tree\n"
        "  treedag --help\n"
        "  treedag  [--in] arg [--out] arg [--reverse]\n\n";

    options_description description("Allowed options");
    description.add_options()
            ("help,h", "produce help")
            ("in,i", value<std::string>(),
                "the file to read the graph from (in tree format)")
            ("out,o", value<std::string>(),
                "the file to write the graph to (in dag format)")
            ("reverse,r", "reverse edges in the tree");

    positional_options_description positionals;
    positionals.add("in", 1);
    positionals.add("out", 1);

    return lib::entrypoint(entrypoint, argc, argv, message, description, positionals);
}