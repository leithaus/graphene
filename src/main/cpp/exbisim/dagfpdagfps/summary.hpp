/**
 * summary.hpp - Structural summary and structural summary dummy.
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
#ifndef INCLUDE_SUMMARY_HPP_
#define INCLUDE_SUMMARY_HPP_
#include "lib/binaryreader.hpp"
#include "common/records.hpp"
#include "common/types.hpp"
#include "common/priorityqueue.hpp"

/**
 * Structure summaries for nodes.
 */
class Summary
{
public:
    /**
     * Construct a hash based structural summary.
     */
    Summary();

    /**
     * Calculate the structural hash for the provided node.
     *
     *     @param node   The node to get a hash for.
     *     @param label  The label of the node.
     *     @return the structural hash of the node.
     */
    uint hash(uint node, uint label);

    /**
     * Calculate the rank for the provided node.
     *
     *     @param node  The node to get a rank for.
     *     @return the rank of the node.
     */
    uint rank(uint node);

    /**
     * Send the rank and hash information to a parent.
     *
     *     @param rank    The rank to send to a parent.
     *     @param hash    The hash to send to a parent.
     *     @param parent  The parent to send rank, hash to.
     *     @throws const char[] when the input is invalid.
     */
    void push(uint rank, uint hash, uint parent);

private:
    /* Priority queue used for forward processing ranks. */
    PriorityQueue rank_queue;

    /* Priority queue used for forward processing structure hashes. */
    PriorityQueue hash_queue;
};

#endif