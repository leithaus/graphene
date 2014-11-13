/**
 * xmldagfpr.hpp - Generate dagfp graphs from xml documents.
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
#ifndef INCLUDE_XMLDAGFPR_HPP_
#define INCLUDE_XMLDAGFPR_HPP_
#include "common/records.hpp"
#include "common/xmlread.hpp"
#include "lib/binarywriter.hpp"
#include "lib/stxxl/wrapper.hpp"

/**
 * Process attributes of a node.
 *
 *     @param Label    Type of the label structure.
 *     @param reader   Pointer to the current XML reader.
 *     @param label    The label structure for generating label identifiers.
 *     @param log      Pointer to optional label logger.
 *     @param parents  The path to the root for the current node.
 *     @param labels   The node labels in the xml document.
 *     @param edges    The edges in the xml document.
 */
template<class Label> void process_attributes(xmlTextReaderPtr reader,
                                              Label& label, std::ofstream* log,
                                              stxxl::VECTOR_GENERATOR<uint>::result& parents,
                                              stxxl::VECTOR_GENERATOR<uint>::result& labels,
                                              stxxl::VECTOR_GENERATOR<Edge>::result& edges);

/**
 * Process a node; will only process open- and close tags. Other tags are
 * ignored.
 *
 *     @param Label    Type of the label structure.
 *     @param reader   Pointer to the current XML reader.
 *     @param label    The label structure for generating label identifiers.
 *     @param log      Pointer to optional label logger.
 *     @param parents  The path to the root for the current node.
 *     @param labels   The node labels in the xml document.
 *     @param edges    The edges in the xml document.
 */
template<class Label> void process_node(xmlTextReaderPtr reader,
                                        Label& label, std::ofstream* log,
                                        stxxl::VECTOR_GENERATOR<uint>::result& parents,
                                        stxxl::VECTOR_GENERATOR<uint>::result& labels,
                                        stxxl::VECTOR_GENERATOR<Edge>::result& edges);

/**
 * Read an xml document into a time-forward processable format.
 *
 *     @param reader   Pointer to the current XML reader.
 *     @param log      Pointer to optional label logger.
 *     @param hashing  True if label identifiers should be generated using
 *                     hashing.
 *     @param labels   The node labels in the xml document.
 *     @param edges    The edges in the xml document.
 */
void read_xml(xmlTextReaderPtr reader, std::ofstream* log, bool hashing,
              stxxl::VECTOR_GENERATOR<uint>::result& labels,
              stxxl::VECTOR_GENERATOR<Edge>::result& edges);

/**
 * Write xml document in dagfp format (reversed edges).
 *
 *     @param labels  Vector containing all labels of nodes.
 *     @param edges   Vector containing all dag edges.
 *     @param sizes   The number of parents for each node.
 *     @param out     The output stream to write to.
 */
void write_dagfpr(const stxxl::VECTOR_GENERATOR<uint>::result& labels,
                  const stxxl::VECTOR_GENERATOR<Edge>::result& edges,
                  lib::BinaryWriter<uint>& out);

#endif