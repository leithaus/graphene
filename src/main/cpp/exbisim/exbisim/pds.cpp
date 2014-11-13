/**
 * pds.cpp - External memory partition decision structure.
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
#include <algorithm>
#include "pds.hpp"

PDS::PDS() : collisions(0), collisions_local_max(0), collisions_local(0),
             partition_id(0), storage(), query_buffer() { }

void PDS::flush()
{
    collisions_local_max = std::max(collisions_local, collisions_local_max);
    collisions += collisions_local;
    collisions_local = 0;
    storage.clear();
}

uint PDS::query(uint num,
                const lib::stxxl::Buffer<CountHash<Edge>>& outgoing, std::uint64_t& index)
{
    query_buffer.clear();
    for (uint i = 0; i < num; ++i, ++index)
    {
        query_buffer.push_back(outgoing[index].value.to);
    }

    for (std::uint64_t i = 0, end = storage.size(); i != end; ++i)
    {
        bool match = true;
        for (uint j = 0; j < num; ++j, ++i)
        {
            match &= (query_buffer[j] == storage[i]);
        }
        if (match)
        {
            return storage[i];
        }
    }

    if (!storage.empty())
    {
        ++collisions_local;
    }
    for (uint i = 0; i < num; ++i)
    {
        storage.push_back(query_buffer[i]);
    }
    storage.push_back(partition_id);
    return partition_id++;
}

uint PDS::stat_collisions() const
{
    return collisions;
}

uint PDS::stat_local_collisions() const
{
    return collisions_local_max;
}

uint PDS::stat_partitions() const
{
    return partition_id;
}