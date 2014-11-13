/**
 * priorityqueue.hpp - Forward processing priority queue.
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
#ifndef INCLUDE_COMMON_PRIORITYQUEUE_HPP_
#define INCLUDE_COMMON_PRIORITYQUEUE_HPP_
#include "common/records.hpp"
#include "lib/stxxl/wrapper.hpp"

/**
 * Type of the used priority queue for several forward processing algorithms.
 */
#ifndef MEMORY_BLOCK_M
    // General purpose.
    typedef stxxl::PRIORITY_QUEUE_GENERATOR<NodeValue,
            lib::stxxl::Compare<NodeValue, std::greater<NodeValue>, false>,
            MEMORY_BLOCK, 0x7FFFFF>::result PriorityQueue;
#else
    // Works for 2+ MB of internal memory.
    typedef stxxl::PRIORITY_QUEUE_GENERATOR<NodeValue,
            lib::stxxl::Compare<NodeValue, std::greater<NodeValue>, false>,
            MEMORY_BLOCK, 0x7FFFF>::result PriorityQueue;
#endif

#endif