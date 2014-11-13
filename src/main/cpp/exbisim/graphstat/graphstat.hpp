/**
 * graphstat.cpp - Graph statistics. 
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
#ifndef INCLUDE_GRAPHSTAT_HPP_
#define INCLUDE_GRAPHSTAT_HPP_
#include "common/types.hpp"
#include "lib/binaryreader.hpp"
#include "lib/stxxl/wrapper.hpp"

/**
 * Count the number of unique labels; thereby the labels are sorted first.
 *
 *     @param labels  List of labels.
 *     @return the number of labels.
 */
uint label_count_s(stxxl::VECTOR_GENERATOR<uint>::result& labels);

/**
 * Calculate statistics for trees; print them to standard output.
 *
 *     @param labels  List of labels.
 *     @param in      The input stream to read from.
 *     @throws const char[] when the format of input is not a valid tree.
 */
void stat_tree(stxxl::VECTOR_GENERATOR<uint>::result& labels, lib::BinaryReader<ubyte>& in);

/**
 * Calculate statistics for dags; print them to standard output.
 *
 *     @param labels  List of labels.
 *     @param in      The input stream to read from.
 *     @throws const char[] when the format of input is not a valid dag.
 */
void stat_dag(stxxl::VECTOR_GENERATOR<uint>::result& labels, lib::BinaryReader<uint>& in);

/**
 * Calculate statistics for dags (fp); print them to standard output.
 *
 *     @param labels  List of labels.
 *     @param in      The input stream to read from.
 *     @throws const char[] when the format of input is not a valid dagfp.
 */
void stat_dagfp(stxxl::VECTOR_GENERATOR<uint>::result& labels, lib::BinaryReader<uint>& in);

/**
 * Calculate statistics for dag (fps); print them to standard output.
 *
 *     @param labels  List of labels.
 *     @param in      The input stream to read from.
 *     @throws const char[] when the format of input is not a valid dagfps.
 */
void stat_dagfps(stxxl::VECTOR_GENERATOR<uint>::result& labels, lib::BinaryReader<uint>& in);

#endif