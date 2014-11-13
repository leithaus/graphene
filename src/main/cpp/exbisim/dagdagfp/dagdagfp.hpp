/**
 * dagdagfp.hpp - Convert dag DAGs to dagfp DAGs.
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
#ifndef INCLUDE_DAGDAGFP_HPP_
#define INCLUDE_DAGDAGFP_HPP_
#include "common/records.hpp"
#include "lib/binaryreader.hpp"
#include "lib/binarywriter.hpp"
#include "lib/stxxl/wrapper.hpp"

/**
 * Count the number of parents per node; store this number in the sizes vector.
 *
 *     @param nodes  The number of nodes.
 *     @param edges  The set of (from, to) edges sorted on to.
 *     @param sizes  The set wherein the number of parents is stored per node.
 */
void num_parents_node(const uint nodes,
                      const stxxl::VECTOR_GENERATOR<Edge>::result& edges,
                      stxxl::VECTOR_GENERATOR<uint>::result& sizes);

/**
 * Read dag in dag format.
 *
 *     @param labels  Vector to store node labels in; such that the label of the
 *                    i-th node is stored as the i-th element in the vector.
 *     @param edges   Vector containing all dag edges.
 *     @param in      The input stream to read from.
 */
void read_dag(stxxl::VECTOR_GENERATOR<uint>::result& labels,
              stxxl::VECTOR_GENERATOR<Edge>::result& edges,
              lib::BinaryReader<uint>& in);

/**
 * Write dag in dagfp format.
 *
 *     @param labels  Vector containing all labels of nodes.
 *     @param edges   Vector containing all dag edges.
 *     @param sizes   The number of parents for each node.
 *     @param out     The output stream to write to.
 */
void write_dagfp(const stxxl::VECTOR_GENERATOR<uint>::result& labels,
                 const stxxl::VECTOR_GENERATOR<Edge>::result& edges,
                 const stxxl::VECTOR_GENERATOR<uint>::result& sizes,
                 lib::BinaryWriter<uint>& out);

#endif