/**
 * array.hpp - Managed dynamic array.
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
#ifndef INCLUDE_LIB_ARRAY_HPP_
#define INCLUDE_LIB_ARRAY_HPP_
#include <cstddef>

namespace lib
{
    /**
     * Array provides a dynamically allocated array of a specified size.
     * Allocated memory for the array is automatically freed up when the array
     * is deconstructed.
     *
     *     @param Type  The type of the elements stored in the array.
     */
    template<class Type> class Array
    {
    public:
        /**
         * Construct the dynamic array.
         *
         *     @param size   The number of elements in the dynamic array.
         *     @throw std::bad_alloc when the array fails to allocate the
         *                           requested storage space.
         */
        Array(const std::size_t size);

        /**
         * Destruct the dynamic array.
         */
        virtual ~Array();

        /**
         * Returns a reference to the element at the n-th position in the
         * array.
         *
         *     @pre n < size.
         *     @param n  The position in the array.
         *     @return reference to the element at the n-th position.
         */
        const Type& operator[](const std::size_t n) const;

        /**
         * Returns a reference to the element at the n-th position in the
         * array.
         *
         *     @pre n < size().
         *     @param n  The position in the array.
         *     @return reference to the element at the n-th position.
         */
        Type& operator[](const std::size_t n);

        /**
         * Cast the array to a pointer. This pointer p can be safely used in
         * the range [p, p + size) for as long as this array exists.
         */
        operator Type const*() const;

        /**
         * Cast the array to a pointer. This pointer p can be safely used in
         * the range [p, p + size) for as long as this array exists.
         */
        operator Type*();

        /* The number of elements in the dynamic array. */
        const std::size_t size;

    private:
        /* The data hold by this array. */
        Type* data;
    };
}

#include "lib/array_impl.hpp"
#endif