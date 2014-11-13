/**
 * buffer.hpp - Internal/External buffer (vector wrapper).
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
#ifndef INCLUDE_LIB_STXXL_BUFFER_HPP_
#define INCLUDE_LIB_STXXL_BUFFER_HPP_
#include <cstdint>
#include <vector>
#include "lib/stxxl/wrapper.hpp"

namespace lib
{
    namespace stxxl
    {
        /**
         * IO efficient container that is stored in internal memory when the
         * size is bounded by some maximum size. This makes this buffer fast
         * compared to normal stxxl vectors when the amount of data stored in
         * the container is expected to fit in internal memory.
         *
         *     @param Type  The type of elements stored in the buffer.
         */
        template<class Type> class Buffer
        {
        public:
            /**
             * Construct the buffer.
             */
            Buffer();

            /**
             * Return the offset-th element from the buffer.
             *
             *     @param offset  The offset of the element to return.
             */
            const Type& operator[](const std::uint64_t offset) const;

            /**
             * Return the last element from the buffer.
             *
             *     @return the last element from the buffer.
             */
            const Type& back() const;

            /**
             * Clear the buffer.
             */
            void clear();

            /**
             * Return true if the buffer is empty.
             *
             *     @return true if the buffer is empty.
             */
            bool empty() const;

            /**
             * Push an element onto the buffer.
             *
             *     @param value  Value to push to the buffer.
             */
            void push_back(const Type& value);

            /**
             * Sort the elements on the buffer with the provided comparison
             * function.
             *
             *     @param Function  Type of the comparision function.
             *     @param function  The comparision function to use.
             */
            template<class Function> void sort(Function function);

            /**
             * Return the size of the buffer.
             *
             *     @return the size of the buffer.
             */
            std::uint64_t size() const;

        private:
            /* Maximum size of an internal memory vector. */
            const std::size_t max_size;

            /* In-memory vector. */
            std::vector<Type> im_vector;

            /* External-memory vector. */
            typename ::stxxl::VECTOR_GENERATOR<Type>::result ex_vector;

            /* True when using the in-memory vector. */
            bool in_memory;
        };
    }
}

#include "lib/stxxl/buffer_impl.hpp"
#endif