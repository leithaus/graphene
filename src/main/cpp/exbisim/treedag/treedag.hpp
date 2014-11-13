/**
 * treedag.hpp - Convert trees to DAGs.
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
#ifndef INCLUDE_TREEDAG_HPP_
#define INCLUDE_TREEDAG_HPP_
#include "common/records.hpp"
#include "lib/binaryreader.hpp"
#include "lib/binarywriter.hpp"
#include "lib/stxxl/wrapper.hpp"

/**
 * Count the number of children per node; store this number in the sizes vector.
 *
 *     @param nodes  The number of nodes.
 *     @param edges  The set of (from, to) edges sorted on from.
 *     @param sizes  The output set wherein the number of children is stored.
 */
void num_children_node(const uint nodes,
                       const stxxl::VECTOR_GENERATOR<Edge>::result& edges,
                       stxxl::VECTOR_GENERATOR<uint>::result& sizes);

/**
 * Read a tree from and store node and edge information in the provided 
 * structures.
 *
 *     @param nodes  A vector wherein all tree nodes are stored.
 *     @param edges  A vector wherein all tree edges are stored.
 *     @param in     The input stream to read from.
 *     @throws const char[] when the input is invalid.
 */
void read_tree(stxxl::VECTOR_GENERATOR<Node>::result& nodes,
               stxxl::VECTOR_GENERATOR<Edge>::result& edges,
               lib::BinaryReader<ubyte>& in);

/**
 * Process tree nodes and edges; thereby adding constraints stated on nodes and
 * edges as represented by the dag format.
 *
 *     @param nodes  A vector wherein all tree nodes are stored.
 *     @param edges  A vector wherein all tree edges are stored.
 */
void tree_dag(stxxl::VECTOR_GENERATOR<Node>::result& nodes,
              stxxl::VECTOR_GENERATOR<Edge>::result& edges);

/**
 * Process tree nodes and edges; thereby adding constraints stated on nodes and
 * edges as represented by the dag format. Reverse the edges of the tree during
 * processing.
 *
 *     @param nodes  A vector wherein all tree nodes are stored.
 *     @param edges  A vector wherein all tree edges are stored.
 */
void tree_dag_r(stxxl::VECTOR_GENERATOR<Node>::result& nodes,
                stxxl::VECTOR_GENERATOR<Edge>::result& edges);

/**
 * Write the nodes and edges in the dag format. The nodes and edges should
 * satisfy the constraints stated by the dag format.
 *
 *     @param nodes  A vector wherein all tree nodes are stored.
 *     @param edges  A vector wherein all tree edges are stored.
 *     @param sizes   The number of parents for each node.
 *     @param out    The output stream to write to.
 */
void write_dag(const stxxl::VECTOR_GENERATOR<Node>::result& nodes,
               const stxxl::VECTOR_GENERATOR<Edge>::result& edges,
               const stxxl::VECTOR_GENERATOR<uint>::result& sizes,
               lib::BinaryWriter<uint>& out);

#endif