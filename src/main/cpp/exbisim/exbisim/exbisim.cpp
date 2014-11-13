/**
 * exbisim.cpp - External memory bisimulation.
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
#include "lib/entrypoint.hpp"
#include "lib/hash.hpp"
#include "exbisim.hpp"
#include "pds.hpp"

uint annotate_edges(const CountHash<Void>& countHash, uint node,
                    lib::BinaryReader<uint>& in,
                    lib::stxxl::Buffer<uint>& childBlocks,
                    lib::stxxl::Buffer<CountHash<Edge>>& incoming,
                    lib::stxxl::Buffer<CountHash<Edge>>& outgoing)
{
    for (std::uint64_t i = 0, end = childBlocks.size(); i != end; ++i)
    {
        CountHash<Edge> edge = { countHash.count, countHash.hash,
                                 { node, childBlocks[i] } };
        outgoing.push_back(edge);
    }
    childBlocks.clear();

    uint parents = in.read();
    for (uint k = 0; k < parents; ++k)
    {
        uint parent = in.read();
        if (parent <= node)
        {
            throw "Invalid parent edge, parent does not appear after node.";
        }

        CountHash<Edge> edge = { countHash.count, countHash.hash,
                                 { parent, node } };
        incoming.push_back(edge);
    }
    return parents;
}

void bisim_dagfps(bool stats, lib::BinaryReader<uint>& in,
                  lib::BinaryWriter<PartitionNodePair>& out)
{
    using lib::stxxl::less;

    uint groups = in.read();
    uint node = 0;

    lib::stxxl::Buffer<CountHash<NodeValue>> nodes;
    lib::stxxl::Buffer<uint> childBlocks;
    lib::stxxl::Buffer<CountHash<Edge>> incoming;
    lib::stxxl::Buffer<CountHash<Edge>> outgoing;
    lib::stxxl::Buffer<uint> sizes;

    PriorityQueue Q(MEMORY_BLOCK, MEMORY_BLOCK);
    PDS pds;

    uint partitions = 0;
    uint partitionLocalMax = 0;
    uint partitionLocal = 0;

    for (uint i = 0; i < groups; ++i)
    {
        uint groupNodes = in.read();
        uint rank = in.read();
        uint label = in.read();

        for (uint j = 0; j < groupNodes; ++j, ++node)
        {
            CountHash<Void> countHash = child_partition_count_hash(Q, node, childBlocks);
            uint parents = annotate_edges(countHash, node, in, childBlocks, incoming, outgoing);

            CountHash<NodeValue> annotatedNode = { countHash.count, countHash.hash,
                                                   { node, parents } };
            nodes.push_back(annotatedNode);
        }

        incoming.sort(less<CountHash<Edge>>(less_to));
        outgoing.sort(less<CountHash<Edge>>());
        nodes.sort(less<CountHash<NodeValue>>());

        partitionLocal = 0;
        for (std::uint64_t i = 0, end = nodes.size(); i != end;)
        {
            ++partitionLocal;
            uint count = nodes[i].count;
            uint hash = nodes[i].hash;
            uint num = 0;

            for (; (i != end) && ((nodes[i].count == count) && (nodes[i].hash == hash)); ++i)
            {
                ++num;
            }
            sizes.push_back(num);
        }
        partitions += partitionLocal;
        partitionLocalMax = std::max(partitionLocal, partitionLocalMax);

        bisim_group(Q, pds, sizes, nodes, incoming, outgoing, out);

        sizes.clear();
        incoming.clear();
        outgoing.clear();
        nodes.clear();
    }

    if (stats)
    {
        stxxl::stats& stats = *stxxl::stats::get_instance();
        std::cout << "Nodes: " << node << "\n"
                     "Partitions (in): " << groups << "\n"
                     "Partitions (local): " << partitions << "\n"
                     "Partitions (local, max): " << partitionLocalMax << "\n"
                     "Partitions (out): " << pds.stat_partitions() << "\n"
                     "Collisions (total): " << pds.stat_collisions() << "\n"
                     "Collisions (local, max): " << pds.stat_local_collisions() << "\n"
                     "(STXXL) Reads: " << stats.get_reads() << "\n"
                     "(STXXL) Writes: " << stats.get_writes() << "\n"
                     "(STXXL) Reads (bytes): " << stats.get_read_volume() << "\n"
                     "(STXXL) Writes (bytes: " << stats.get_written_volume() << "\n";
    }
}

void bisim_group(PriorityQueue& Q, PDS& pds,
                 lib::stxxl::Buffer<uint>& sizes,
                 lib::stxxl::Buffer<CountHash<NodeValue>>& nodes,
                 lib::stxxl::Buffer<CountHash<Edge>>& incoming,
                 lib::stxxl::Buffer<CountHash<Edge>>& outgoing,
                 lib::BinaryWriter<PartitionNodePair>& out)
{
    std::uint64_t iit = 0, iend = incoming.size();
    std::uint64_t oit = 0, oend = outgoing.size();
    std::uint64_t nit = 0, nend = nodes.size();
    for (uint j = 0, end = sizes.size(); j != end; ++j)
    {
        for (uint i = 0, numNodes = sizes[j]; i != numNodes; ++i, ++nit)
        {
            uint partitionBlock = pds.query(nodes[nit].count, outgoing, oit);
            for (uint j = 0, numParents = nodes[nit].value.value; j != numParents; ++j, ++iit)
            {
                NodeValue p = { incoming[iit].value.from, partitionBlock };
                Q.push(p);
            }

            PartitionNodePair pair = { partitionBlock, nodes[nit].value.identifier };
            out << pair;
        }
        pds.flush();
    }
}

CountHash<Void> child_partition_count_hash(PriorityQueue& Q, uint node,
         lib::stxxl::Buffer<uint>& childBlocks)
{
    uint count = 0;
    lib::Hash<uint> hash;
    while (!Q.empty() && (Q.top().identifier == node))
    {
        if (childBlocks.empty() || (childBlocks.back() != Q.top().value))
        {
            ++count;
            uint childBlock = Q.top().value;
            hash(childBlock);
            childBlocks.push_back(childBlock);
        }
        Q.pop();
    }

    CountHash<Void> countHash = { count, hash.value(), { } };
    return countHash;
}

inline bool less_to(const CountHash<Edge>& left, const CountHash<Edge>& right)
{
    return CountHash<Edge>::less(left, right, Edge::less_to);
}

void entrypoint(int argc, const char* argv[],
                boost::program_options::variables_map& variables)
{
    lib::BinaryReader<uint> in(lib::get_argument<std::string>(variables, "in"));
    lib::BinaryWriter<PartitionNodePair> out(lib::get_argument<std::string>(variables, "out"));
    uint format = in.read();
    if (format == Format::DAGFPS)
    {
        bisim_dagfps(variables.count("stats") == 1, in, out);
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
        "Perform external memory isimulation on dags (in dagfps format)\n"
        "  exbisim --help\n"
        "  exbisim [--in] arg [--out] arg [--stats]\n\n";

    options_description description("Allowed options");
    description.add_options()
            ("help,h", "produce help")
            ("in,i", value<std::string>(),
                "the file to read the graph from (in dagfps format)")
            ("out,o", value<std::string>(),
                "the file to write the partition to")
            ("stats,s", "flag to enable the collection and writing of "
                "statistics");

    positional_options_description positionals;
    positionals.add("in", 1);
    positionals.add("out", 1);

    return lib::entrypoint(entrypoint, argc, argv, message, description, positionals);
}