/**
 * compare.hpp - STXXL-compatible comparison functions.
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
#ifndef INCLUDE_LIB_STXXL_COMPARE_HPP_
#define INCLUDE_LIB_STXXL_COMPARE_HPP_
#include <functional>
#include <type_traits>

namespace lib
{
    namespace stxxl 
    {
        /**
         * Compare class carries a compare function, a minimum and a maximum
         * value. These elements are required for usage of a comparator by STXXL
         * libraries.
         *
         *     @param Type      Type of the value elements compared.
         *     @param Function  Type of the comparator function.
         *     @param less      True if the ordering of Type elements is from
         *                      lexicographically smaller to larger elements.
         */
        template<class Type, class Function, bool less> class Compare
        {
        public:
            /**
             * Construct a default-STXXL compare object.
             */
            Compare();

            /**
             * Construct a STXXL compare object.
             *
             *     @param cmp  The compare function to use.
             */
            Compare(Function cmp);

            /**
             * Compare two objects, return cmp(left, right).
             *
             *     @param left   The first object.
             *     @param right  The second object.
             */
            bool operator()(const Type& left, const Type& right) const;

            /**
             * Return the maximum value.
             *
             *     @return return the maximum value.
             */
            const Type& max_value() const;

            /**
             * Return the minimum value.
             *
             *     @return return the minimum value.
             */
            const Type& min_value() const;

        private:
            /* The compare function to use. */
            Function cmp;

            /* The maximum value. */
            const Type max;

            /* and minimum value. */
            const Type min;
        };

        /**
         * Construct a STXXL-compatible compare object for the operator<
         * function.Elements are ordered normally.
         *
         *     @param Type  Type of the value elements compared.
         *     @return the compare object.
         */
        template<class Type>
            Compare<Type, std::less<Type>, true> less();
        
        /**
         * Construct a STXXL-compatible compare object for a compare function
         * wherein elements are ordered normally.
         *
         *     @param Type      Type of the value elements compared.
         *     @param Function  Type of the comparator function.
         *     @param cmp  The compare function to use.
         *     @return the compare object.
         */
        template<class Type, class Function>
            Compare<Type, Function, true> less(Function cmp);

        /**
         * Construct a STXXL-compatible compare object for the operator>
         * function. Elements are reversed ordered.
         *
         *     @param Type  Type of the value elements compared.
         *     @return the compare object.
         */
        template<class Type>
            Compare<Type, std::greater<Type>, false> greater();

        /**
         * Construct a STXXL-compatible compare object for a compare function
         * wherein elements are reverse ordered normally.
         *
         *     @param Type      Type of the value elements compared.
         *     @param Function  Type of the comparator function.
         *     @param cmp  The compare function to use.
         *     @return the compare object.
         */
        template<class Type, class Function>
            Compare<Type, Function, false> greater(Function cmp);
    }
}

#include "lib/stxxl/compare_impl.hpp"
#endif