/**
 * dagfpdagfps.hpp - Convert dagfp DAGs to dagfps DAGs.
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
#ifndef INCLUDE_DAGFPDAGFPS_HPP_
#define INCLUDE_DAGFPDAGFPS_HPP_
#include "common/records.hpp"
#include "lib/binaryreader.hpp"
#include "lib/binarywriter.hpp"
#include "lib/stxxl/wrapper.hpp"

/**
 * Reorder nodes based on rank and label. Renumber nodes and edges based on this
 * reordering.
 *
 *     @param nodes  Vector to store node information in.
 *     @param edges  Vector containing all dag edges.
 */
void dag_renumber(stxxl::VECTOR_GENERATOR<AnnotatedNode>::result& nodes,
                  stxxl::VECTOR_GENERATOR<Edge>::result& edges);

/**
 * Calculate for the set of nodes ordered on (rank, label) how many nodes there
 * are in each combination of (rank, label). Store these counts in order.
 *
 *     @param nodes           Vector to store node information in.
 *     @param structureSizes  Vector to store (rank, label, hash) set sizes in.
 *     @param rankLabelSizes  Vector to store (rank, label) set sizes in.
 */
void node_structure_sizes(const stxxl::VECTOR_GENERATOR<AnnotatedNode>::result& nodes,
                          stxxl::VECTOR_GENERATOR<uint>::result& structureSizes,
                          stxxl::VECTOR_GENERATOR<uint>::result& rankLabelSizes);

/**
 * Read dag in dagfp format; calculate rank of each node during reading.
 *
 *     @param nodes  Vector to store node information in.
 *     @param edges  Vector containing all dag edges.
 *     @param in     The input stream to read from.
 */
void read_dagfp_rank(stxxl::VECTOR_GENERATOR<AnnotatedNode>::result& nodes,
                     stxxl::VECTOR_GENERATOR<Edge>::result& edges,
                     lib::BinaryReader<uint>& in);

/**
 * Write dag in dagfps format.
 *
 *     @param nodes  Vector to store node information in.
 *     @param sizes  Vector to store (rank, label) set sizes in.
 *     @param edges  Vector containing all dag edges.
 *     @param out    The output stream to write to.
 */
void write_dagfps(const stxxl::VECTOR_GENERATOR<AnnotatedNode>::result& nodes,
                  const stxxl::VECTOR_GENERATOR<uint>::result& sizes,
                  const stxxl::VECTOR_GENERATOR<Edge>::result& edges,
                  lib::BinaryWriter<uint>& out);

#endif