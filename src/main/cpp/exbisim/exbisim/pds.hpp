/**
 * pds.hpp - External memory partition decision structure.
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
#ifndef INCLUDE_PDS_HPP_
#define INCLUDE_PDS_HPP_
#include "common/records.hpp"
#include "common/types.hpp"
#include "lib/stxxl/buffer.hpp"

/**
 * External memory partition decision structure.
 */
class PDS
{
public:
    /**
     * Construct the partition decision structure.
     */
    PDS();

    /**
     * Flush the partition decision structure, indicating that the current part
     * of the structure is not longer needed by the algorithm.
     */
    void flush();

    /**
     * Query the partition decision structure for the partition block identifier
     * associated with the first num to-elements from the outgoing edge list.
     * When no entry exists for these num to-elements; then create a new
     * partition block for these elements.
     *
     *     @param num       The number of outgoing edges to read.
     *     @param outgoing  The outgoing edge buffer.
     *     @param index     The index in the outgoing edge buffer.
     *     @return the partition block identifier.
     */
    uint query(uint num, const lib::stxxl::Buffer<CountHash<Edge>>& outgoing, std::uint64_t& index);

    /**
     * Return the number of collisions.
     *
     *     @return the number of collisions.
     */
    uint stat_collisions() const;

    /**
     * Return the maximum number of collisions in a local partition.
     *
     *     @return the maximum number of collisions in a local partition
     */
    uint stat_local_collisions() const;

    /**
     * Return the number of created bisimulation partitions.
     *
     *     @return return the number of created bisimulation partitions.
     */
    uint PDS::stat_partitions() const;

private:
    /* Total number of local collisions. */
    uint collisions;

    /* Maximum number of local collisions per partition. */
    uint collisions_local_max;

    /* Number of local collisions for current partition. */
    uint collisions_local;

    /* The identifier for the next partition block. */
    uint partition_id;

    /* The vector wherein the partition decision structure is stored. */
    lib::stxxl::Buffer<uint> storage;

    /* The query buffer wherein the query is buffered during execution. */
    lib::stxxl::Buffer<uint> query_buffer;
};

#endif