/**
 * summary.cpp - Structural summary and structural summary dummy.
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
#include "lib/hash.hpp"
#include "summary.hpp"

Summary::Summary() : rank_queue(MEMORY_BLOCK, MEMORY_BLOCK),
                     hash_queue(MEMORY_BLOCK, MEMORY_BLOCK) { }

uint Summary::hash(uint node, uint label)
{
    lib::Hash<uint> hash;
    hash(label);
    while ((!hash_queue.empty()) && (hash_queue.top().identifier == node))
    {
        uint value = hash_queue.top().value;
        hash(value);

        while ((!hash_queue.empty()) &&
                    (hash_queue.top().identifier == node) &&
                            (hash_queue.top().value == value))
        {
            hash_queue.pop();
        }
    }
    return hash.value();
}

uint Summary::rank(uint node)
{
    uint rank = 0;
    while ((!rank_queue.empty()) && (rank_queue.top().identifier == node))
    {
        rank = rank_queue.top().value;
        rank_queue.pop();
    }
    return rank;
}

void Summary::push(uint rank, uint hash, uint parent)
{
    NodeValue ranking = { parent, rank + 1 };
    rank_queue.push(ranking);

    NodeValue hashing = { parent, hash };
    hash_queue.push(hashing);
}