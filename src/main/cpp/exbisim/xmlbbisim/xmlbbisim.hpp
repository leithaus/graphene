/**
 * xmlbbisim.hpp - Backward bisimulate xml documents.
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
#ifndef INCLUDE_XMLBBISIM_HPP_
#define INCLUDE_XMLBBISIM_HPP_
#include "common/xmlread.hpp"
#include "lib/binarywriter.hpp"
#include "lib/stxxl/compare.hpp"
#include "lib/stxxl/wrapper.hpp"
#include "xmlrecords.hpp"

/**
 * Type of comparator used by the priority queue for time-forward processing.
 */
typedef lib::stxxl::Compare<XmlNodePartitionBlock,
                            std::greater<XmlNodePartitionBlock>,
                            false> PriorityQueueComparator;

/**
 * The priority queue for time-forward processing.
 */
typedef stxxl::PRIORITY_QUEUE_GENERATOR<XmlNodePartitionBlock,
        PriorityQueueComparator, MEMORY_BLOCK, 0x7FFFFF>::result PriorityQueue;

/**
 * Process attributes of a node.
 *
 *     @param Label     Type of the label structure.
 *     @param reader    Pointer to the current XML reader.
 *     @param label     The label structure for generating label identifiers.
 *     @param log       Pointer to optional label logger.
 *     @param rank      Rank of the node that is read.
 *     @param numNodes  Number of nodes (per rank, rank is index).
 *     @param nodes     The nodes in the xml document.
 *     @param edges     The edges in the xml document.
 */
template<class Label>
        void process_attributes(xmlTextReaderPtr reader, Label& label, std::ofstream* log,
                                uint rank, stxxl::VECTOR_GENERATOR<uint>::result& numNodes,
                                stxxl::VECTOR_GENERATOR<XmlNode>::result& nodes,
                                stxxl::VECTOR_GENERATOR<XmlEdge>::result& edges);

/**
 * Process a node; will only process open- and close tags. Other tags are
 * ignored.
 *
 *     @param Label     Type of the label structure.
 *     @param reader    Pointer to the current XML reader.
 *     @param label     The label structure for generating label identifiers.
 *     @param log       Pointer to optional label logger.
 *     @param rank      Rank of the node that is read.
 *     @param numNodes  Number of nodes (per rank, rank is index).
 *     @param nodes     The nodes in the xml document.
 *     @param edges     The edges in the xml document.
 */
template<class Label>
        void process_node(xmlTextReaderPtr reader, Label& label, std::ofstream* log,
                          uint& rank, stxxl::VECTOR_GENERATOR<uint>::result& numNodes,
                          stxxl::VECTOR_GENERATOR<XmlNode>::result& nodes,
                          stxxl::VECTOR_GENERATOR<XmlEdge>::result& edges);

/**
 * Read an xml document into a time-forward processable format.
 *
 *     @param reader    Pointer to the current XML reader.
 *     @param log       Pointer to optional label logger.
 *     @param hashing   True if label identifiers should be generated using
 *                      hashing.
 *     @param numNodes  Number of nodes (per rank, rank is index).
 *     @param nodes     The nodes in the xml document.
 *     @param edges     The edges in the xml document.
 */
void read_xml(xmlTextReaderPtr reader,
              std::ofstream* log, const bool hashing,
              stxxl::VECTOR_GENERATOR<uint>::result& numNodes,
              stxxl::VECTOR_GENERATOR<XmlNode>::result& nodess,
              stxxl::VECTOR_GENERATOR<XmlEdge>::result& edges);

/**
 * Backward bisimulate the tree read from some xml source.
 *
 *     @param numNodes  Number of nodes (per rank, rank is index).
 *     @param nodes     The nodes in the xml document.
 *     @param edges     The edges in the xml document.
 *     @param out       The output stream to write to. 
 */
uint tree_bbisim(const stxxl::VECTOR_GENERATOR<uint>::result& numNodes,
                 const stxxl::VECTOR_GENERATOR<XmlNode>::result& nodes,
                 const stxxl::VECTOR_GENERATOR<XmlEdge>::result& edges,
                 lib::BinaryWriter<XmlPartitionNodePair>& out);

#endif