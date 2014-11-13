/**
 * dagfpdagfps.cpp - Convert dagfp DAGs to dagfps DAGs.
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
#include <limits>
#include "common/format.hpp"
#include "common/priorityqueue.hpp"
#include "common/types.hpp"
#include "lib/array.hpp"
#include "lib/entrypoint.hpp"
#include "lib/stxxl/compare.hpp"
#include "dagfpdagfps.hpp"
#include "summary.hpp"

void dag_renumber(stxxl::VECTOR_GENERATOR<AnnotatedNode>::result& nodes,
                  stxxl::VECTOR_GENERATOR<Edge>::result& edges)
{
    stxxl::sort(nodes.begin(), nodes.end(), lib::stxxl::less<AnnotatedNode>(), MEMORY_BLOCK);

    stxxl::VECTOR_GENERATOR<NodeRenumber>::result renumber;

    uint i = 0;
    for (auto it = nodes.begin(), end = nodes.end(); it != end; ++it, ++i)
    {
        NodeRenumber node = { it->identifier, i };
        renumber.push_back(node);
        it->identifier = i;
    }

    stxxl::sort(renumber.begin(), renumber.end(), lib::stxxl::less<NodeRenumber>(), MEMORY_BLOCK);
    auto eit = edges.begin(), eend = edges.end();
    for (auto it = renumber.cbegin(), end = renumber.cend(); it != end; ++it)
    {
        for (; (eit != eend) && (eit->to == it->from); ++eit)
        {
            eit->to = it->to;
        }
    }

    stxxl::sort(edges.begin(), edges.end(), lib::stxxl::less<Edge>(), MEMORY_BLOCK);
    eit = edges.begin();
    for (auto it = renumber.cbegin(), end = renumber.cend(); it != end; ++it)
    {
        for (; (eit != eend) && (eit->from == it->from); ++eit)
        {
            eit->from = it->to;
        }
    }

    stxxl::sort(edges.begin(), edges.end(), lib::stxxl::less<Edge>(Edge::less_to), MEMORY_BLOCK);
}

void node_structure_sizes(const stxxl::VECTOR_GENERATOR<AnnotatedNode>::result& nodes,
                          stxxl::VECTOR_GENERATOR<uint>::result& structureSizes,
                          stxxl::VECTOR_GENERATOR<uint>::result& rankLabelSizes)
{
    auto it = nodes.cbegin(), end = nodes.cend();
    while (it != end)
    {
        uint rank = it->rank;
        uint label = it->label;

        uint rankLabelCount = 0;
        do
        {
            uint hash = it->summary;

            uint structureCount = 0;
            do 
            {
                ++structureCount;
                ++rankLabelCount;
                ++it;
            }
            while ((it != end) &&
                        (it->rank == rank) && (it->label == label) && (it->summary == hash));
            structureSizes.push_back(structureCount);
        }
        while ((it != end) && (it->rank == rank) && (it->label == label));
        rankLabelSizes.push_back(rankLabelCount);
    }
}

void read_dagfp_rank(stxxl::VECTOR_GENERATOR<AnnotatedNode>::result& nodes,
                     stxxl::VECTOR_GENERATOR<Edge>::result& edges,
                     lib::BinaryReader<uint>& in)
{
    Summary summaries;

    uint num = in.read();
    for (uint i = 0; i < num; ++i)
    {
        uint label = in.read();
        uint rank = summaries.rank(i);
        uint hash = summaries.hash(i, label);

        uint parents = in.read();
        for (uint j = 0; j < parents; ++j)
        {
            uint parent = in.read();
            if (parent <= i)
            {
                throw "Invalid parent edge, parent does not appear after node.";
            }
            summaries.push(rank, hash, parent);

            Edge edge = { parent, i };
            edges.push_back(edge);
        }
     
        AnnotatedNode node = { rank, label, hash, i, parents };
        nodes.push_back(node);
    }
}

void write_dagfps(const stxxl::VECTOR_GENERATOR<AnnotatedNode>::result& nodes,
                  const stxxl::VECTOR_GENERATOR<uint>::result& sizes,
                  const stxxl::VECTOR_GENERATOR<Edge>::result& edges,
                  lib::BinaryWriter<uint>& out)
{
    out << Format::DAGFPS << (uint) sizes.size();

    auto eit = edges.cbegin(), eend = edges.cend();
    auto nit = nodes.cbegin(), nend = nodes.cend();

    for (auto it = sizes.cbegin(), end = sizes.cend(); it != end; ++it)
    {
        out << *it << nit->rank << nit->label;
        for (uint i = 0, nodes = *it; i < nodes; ++i, ++nit)
        {
            out << nit->parents;
            for (uint j = 0, parents = nit->parents; j != parents; ++j, ++eit)
            {
                out << eit->from;
            }
        }
    }
}

void entrypoint(int argc, const char* argv[],
                boost::program_options::variables_map& variables)
{
    stxxl::VECTOR_GENERATOR<Edge>::result edges;
    stxxl::VECTOR_GENERATOR<AnnotatedNode>::result nodes;

    lib::BinaryReader<uint> in(lib::get_argument<std::string>(variables, "in"));
    if (in.read() != Format::DAGFP)
    {
        throw "Input format is not recognized.";
    }

    read_dagfp_rank(nodes, edges, in);
    dag_renumber(nodes, edges);

    stxxl::VECTOR_GENERATOR<uint>::result structureSizes;
    stxxl::VECTOR_GENERATOR<uint>::result rankLabelSizes;
    node_structure_sizes(nodes, structureSizes, rankLabelSizes);
    if (variables.count("ssout") == 1)
    {
        lib::BinaryWriter<uint> out(lib::get_argument<std::string>(variables, "ssout"));
        write_dagfps(nodes, structureSizes, edges, out);
    }
    if (variables.count("nossout") == 1)
    {
        lib::BinaryWriter<uint> out(lib::get_argument<std::string>(variables, "nossout"));
        write_dagfps(nodes, rankLabelSizes, edges, out);
    }

    if (variables.count("stats") != 0)
    {
        stxxl::stats& stats = *stxxl::stats::get_instance();
        std::cout << "(STXXL) Reads: " << stats.get_reads() << "\n"
                     "(STXXL) Writes: " << stats.get_writes() << "\n"
                     "(STXXL) Reads (bytes): " << stats.get_read_volume() << "\n"
                     "(STXXL) Writes (bytes: " << stats.get_written_volume() << "\n";
    }
}

int main(int argc, const char* argv[])
{
    using namespace boost::program_options;
    static const char message[] =
        "Convert a graph in dagfp format to a graph in dagfps format\n"
        "  dagfpdagfps --help\n"
        "  dagfpdagfps [--in] arg [[--ssout] arg] [[--nossout] arg] [--stats]\n\n";

    options_description description("Allowed options");
    description.add_options()
            ("help,h", "produce help")
            ("in,i", value<std::string>(),
                "the file to read the graph from (in dagfp format)")
            ("ssout,o", value<std::string>(),
                "the file to write the graph to (in dagfps format); using  "
                "structural summaries for further refining the resulting "
                "partition; thereby decreasing the number of partition blocks "
                "in the output.")
            ("nossout,n", value<std::string>(),
                "the file to write the graph to (in dagfps format); without "
                "using structural summaries for further refining the resulting "
                "partition; thereby decreasing the number of partition blocks "
                "in the output.")
            ("stats,s", "flag to enable the collection and writing of "
                "statistics");

    positional_options_description positionals;
    positionals.add("in", 1);
    positionals.add("ssout", 1);
    positionals.add("nossout", 1);

    return lib::entrypoint(entrypoint, argc, argv, message, description, positionals);
}