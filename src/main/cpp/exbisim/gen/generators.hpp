/**
 * generators.hpp - Generators for random trees and DAGs.
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
#ifndef INCLUDE_GENERATORS_HPP_
#define INCLUDE_GENERATORS_HPP_
#include "lib/binarywriter.hpp"
#include "label.hpp"

/**
 * Generate a transitive closure chain directed acyclic graph
 *
 *     @param label   The label generator.
 *     @param length  The length of each chain.
 *     @param num     The number of chains to generate.
 *     @param out    The output stream to write to.
 */
void dag_chaintc(Label& label, const uint length, const uint num,
                 lib::BinaryWriter<uint>& out);

/**
 * Generate a random dag whereby every possible edge is picked with given
 * probability.
 *
 *     @param label  The label generator.
 *     @param nodes  Number of nodes in the tree.
 *     @param child  Probability on generating edges.
 *     @param out    The output stream to write to.
 */
void dag_pickedge(Label& label, const uint nodes, const unsigned int edge,
                  lib::BinaryWriter<uint>& out);

/**
 * Generate a random dag.
 *
 *     @param label  The label generator.
 *     @param nodes  Number of nodes in the tree.
 *     @param child  Probability on generating edges.
 *     @param out    The output stream to write to.
 */
void dag_random(Label& label, const uint nodes, const unsigned int edge,
                lib::BinaryWriter<uint>& out);

/**
 * Generate a chain tree.
 *
 *     @param label   The label generator.
 *     @param length  The length of each chain.
 *     @param num     The number of chains to generate.
 *     @param out     The output stream to write to.
 */
void tree_chain(Label& label, const uint length, const uint num,
                lib::BinaryWriter<ubyte>& out);

/**
 * Generate a random tree.
 *
 *     @param label  The label generator.
 *     @param nodes  Number of nodes in the tree.
 *     @param child  Probability on generating children.
 *     @param out    The output stream to write to.
 */
void tree_random(Label& label, const uint nodes, const unsigned int child,
                 lib::BinaryWriter<ubyte>& out);

#endif