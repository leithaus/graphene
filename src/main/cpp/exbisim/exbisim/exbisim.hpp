/**
 * exbisim.hpp - External memory bisimulation.
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
#ifndef INCLUDE_EXBISIM_HPP_
#define INCLUDE_EXBISIM_HPP_
#include "common/priorityqueue.hpp"
#include "common/records.hpp"
#include "lib/binaryreader.hpp"
#include "lib/binarywriter.hpp"
#include "lib/stxxl/buffer.hpp"
#include "pds.hpp"

/**
 * Empty structure used as parameter for CountHash to indicate CountHash values
 * only carrying a count and a hash and no other useful data.
 */
struct Void { };

/**
 * Annotate edges to the child partition blocks and annotate edges from parents.
 *
 *     @param countHash    The count, hash to annotate edges with.
 *     @param node         The node identifier.
 *     @param in           File to read the parents of the current node from.
 *     @param childBlocks  Structure to read child partition blocks from.
 *     @param incoming     Structure to write annotated parent edges to.
 *     @param outgoing     Structure to write annotated child partition blocks
 *                         to.
 *     @return the number of annotated parent edges.
 *     @throws const char[] when the input is invalid.
 */
uint annotate_edges(const CountHash<Void>& countHash, uint node,
                    lib::BinaryReader<uint>& in,
                    lib::stxxl::Buffer<uint>& childBlocks,
                    lib::stxxl::Buffer<CountHash<Edge>>& incoming,
                    lib::stxxl::Buffer<CountHash<Edge>>& outgoing);

/**
 * Bisimulate a directed acyclic graph in externnak memory and write the
 * partition in (partition block identifier, node identifier) pairs to the
 * specified output vector.
 *
 *     @param stats  True if PDS statistics should be shown.
 *     @param in     The input stream to read from.
 *     @param out    The output stream to write to.
 *     @throws const char[] when the input is invalid.
 */
void bisim_dagfps(bool stats, lib::BinaryReader<uint>& in,
                  lib::BinaryWriter<uint>& out);

/**
 * Bisimulate a group of nodes with equivalent rank and label. Process the nodes
 * on increasing (count, hash) values.
 *
 *     @param Q         Priority queue to use to communicate partition block
 *                      identifier of a node to all its parents.
 *     @param pds       The partition decision structure used for assigning
 *                      partition blocks to nodes.
 *     @param sizes     For each (count, hash) value the number of nodes having
 *                      this value.
 *     @param nodes     The nodes in the group, ordered on (count, hash),
 *     @param incoming  Parent edges of the nodes in the group.
 *     @param outgoing  Edges to partition blocks whereto children of the nodes
 *                      in the current group are assigned.
 *     @param out       The output stream to write to.
 */
void bisim_group(PriorityQueue& Q, PDS& pds,
                 lib::stxxl::Buffer<uint>& sizes,
                 lib::stxxl::Buffer<CountHash<NodeValue>>& nodes,
                 lib::stxxl::Buffer<CountHash<Edge>>& incoming,
                 lib::stxxl::Buffer<CountHash<Edge>>& outgoing,
                 lib::BinaryWriter<PartitionNodePair>& out);

/**
 * Retrieve all partition block identifiers wherein children of the current node
 * are placed; nodes are processed in order thus these identifiers should be on
 * top of the priority queue.
 *
 *     @param Q            Queue to read partition block identifiers from.
 *     @param node         The current node.
 *     @param childBlocks  Structure to write all partition block identifiers
 *                         to.
 *     @return the count and hash values calculated over the partition block
 *             identifiers wherein children of the current node are placed.
 */
CountHash<Void> child_partition_count_hash(PriorityQueue& Q, uint node,
        lib::stxxl::Buffer<uint>& childBlocks);


inline bool less_to(const CountHash<Edge>& left, const CountHash<Edge>& right);

#endif