/**
 * dagdagfp.cpp - Convert dag DAGs to dagfp DAGs.
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
#include <functional>
#include <limits>
#include "common/format.hpp"
#include "common/types.hpp"
#include "lib/array.hpp"
#include "lib/entrypoint.hpp"
#include "lib/stxxl/compare.hpp"
#include "dagdagfp.hpp"

void num_parents_node(const uint nodes,
                      const stxxl::VECTOR_GENERATOR<Edge>::result& edges,
                      stxxl::VECTOR_GENERATOR<uint>::result& sizes)
{
    uint node = 0;
    for (auto it = edges.cbegin(), end = edges.cend(); node != nodes; ++node)
    {
        uint count = 0;
        for (; (it != end) && (it->to == node); ++it)
        {
            ++count;
        }
        sizes.push_back(count);
    }
}

void read_dag(stxxl::VECTOR_GENERATOR<uint>::result& labels,
              stxxl::VECTOR_GENERATOR<Edge>::result& edges,
              lib::BinaryReader<uint>& in)
{
    uint num = in.read();
    for (uint i = 0; i < num; ++i)
    {
        uint label = in.read();
        uint children = in.read();
        for (uint j = 0; j < children; ++j)
        {
            uint child = in.read();
            if (child >= i)
            {
                throw "Invalid child edge, child does not appear before node.";
            }

            Edge edge = { i, child };
            edges.push_back(edge);
        }
        labels.push_back(label);
    }
}

void write_dagfp(const stxxl::VECTOR_GENERATOR<uint>::result& labels,
                 const stxxl::VECTOR_GENERATOR<Edge>::result& edges,
                 const stxxl::VECTOR_GENERATOR<uint>::result& sizes,
                 lib::BinaryWriter<uint>& out)
{
    out << Format::DAGFP << (uint) labels.size();

    uint node = 0;
    auto eit = edges.cbegin(), eend = edges.cend();
    auto sit = sizes.cbegin(), send = sizes.cend();
    for (auto it = labels.cbegin(), end = labels.cend(); it != end; ++it, ++sit, ++node)
    {
        uint size = *sit;
        out << *it << size;

        for (uint i = 0; i < size; ++i, ++eit)
        {
            out << eit->from;
        }
    }
}

void entrypoint(int argc, const char* argv[],
                boost::program_options::variables_map& variables)
{
    stxxl::VECTOR_GENERATOR<uint>::result labels;
    stxxl::VECTOR_GENERATOR<Edge>::result edges;
    stxxl::VECTOR_GENERATOR<uint>::result sizes;

    lib::BinaryReader<uint> in(lib::get_argument<std::string>(variables, "in"));
    lib::BinaryWriter<uint> out(lib::get_argument<std::string>(variables, "out"));
    if (in.read() != Format::DAG)
    {
        throw "Input format is not recognized.";
    }

    read_dag(labels, edges, in);
    stxxl::sort(edges.begin(), edges.end(), lib::stxxl::less<Edge>(Edge::less_to), MEMORY_BLOCK);
    num_parents_node(labels.size(), edges, sizes);
    write_dagfp(labels, edges, sizes, out);
}

int main(int argc, const char* argv[])
{
    using namespace boost::program_options;
    static const char message[] =
        "Convert a graph in dag format to a graph in dagfp format\n"
        "  dagdagfp --help\n"
        "  dagdagfp [--in] file [--out] file\n\n";

    options_description description("Allowed options");
    description.add_options()
            ("help,h", "produce help")
            ("in,i", value<std::string>(),
                "the file to read the graph from (in dag format)")
            ("out,o", value<std::string>(),
                "the file to write the graph to (in dagfp format)");

    positional_options_description positionals;
    positionals.add("in", 1);
    positionals.add("out", 1);

    return lib::entrypoint(entrypoint, argc, argv, message, description, positionals);
}