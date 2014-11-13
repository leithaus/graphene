/**
 * vis.hpp - Convert trees and DAGs to Graphviz dot format.
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
#ifndef INCLUDE_VIS_HPP_
#define INCLUDE_VIS_HPP_
#include "common/types.hpp"
#include "lib/binaryreader.hpp"
#include "lib/stxxl/wrapper.hpp"

/**
 * Read a dag (dag format). Write the tree in graphviz dot notation to standard
 * output.
 *
 *     @param in   The input stream to read from.
 *     @param out  The output stream to write to.
 *     @throws const char[] when the input has an invalid format.
 */
void vis_dag(lib::BinaryReader<uint>& in, std::ofstream& out);

/**
 * Read a dag (dagfp format). Write the tree in graphviz dot notation to
 * standard output.
 *
 *     @param in   The input stream to read from.
 *     @param out  The output stream to write to.
 *     @throws const char[] when the input has an invalid format.
 */
void vis_dagfp(lib::BinaryReader<uint>& in, std::ofstream& out);

/**
 * Read a dag (dagfps format) from. Write the tree in graphviz dot notation to
 * standard output.
 *
 *     @param in   The input stream to read from.
 *     @param out  The output stream to write to.
 *     @throws const char[] when the input has an invalid format.
 */
void vis_dagfps(lib::BinaryReader<uint>& in, std::ofstream& out);

/**
 * Write a directed graph edge (from->to); in graphviz dot notation.
 *
 *     @param from   The node identifier of the tail of the edge.
 *     @param to     The node identifier of the head of the edge.
 *     @param out    The output stream to write to.
 */
void vis_edge(const uint from, const uint to, std::ofstream& out);

/**
 * Write a list of graph edges (from->to); in graphviz dot notation.
 *
 *     @param edges  Extrenal memory list of graph edges.
 *     @param out    The output stream to write to.
 */
void vis_edge_file(const stxxl::VECTOR_GENERATOR<Edge>::result& edges, std::ofstream& out);

/**
 * Write a graph node; in graphviz dot notation.
 *
 *     @param out    The output stream to write to.
 *     @param id     The node identifier.
 *     @param label  The node label.
 *     @param out    The output stream to write to.
 */
void vis_node(const uint id, const uint label, std::ofstream& out);

/**
 * Read a tree from. Write the tree in graphviz dot notation to standard
 * output.
 *
 *     @param in   The input stream to read from.
 *     @param out  The output stream to write to.
 *     @throws const char[] when the input has an invalid format.
 */
void vis_tree(std::ifstream& in, std::ofstream& out);

#endif