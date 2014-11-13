/**
 * value.hpp - STXXL-compatible min-max value functions.
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
#ifndef INCLUDE_LIB_STXXL_VALUE_HPP_
#define INCLUDE_LIB_STXXL_VALUE_HPP_

namespace lib
{
    namespace stxxl
    {
        /**
         * Helper structure that aids selection of appropriate minimum and
         * maximum value.
         *
         *     @param Type  Type of the value elements.
         *     @param num   True if this type is a standard integral type.
         */
        template<class Type, bool num = std::is_integral<Type>::value> struct Value
        {
            /**
             * Return the maximum value.
             *
             *     @return the maximum value.
             */
            static const Type max();

            /**
             * Return the minimum value.
             *
             *     @return the minimum value.
             */
            static const Type min();
        };

        /**
         * Specialization for basic numeric types.
         *
         *     @param Type  Type of the value elements.
         */
        template<class Type> struct Value<Type, true>
        {
            /**
             * @see Value<Type, num>::max().
             */
            static const Type max();

            /**
             * @see Value<Type, num>::min().
             */
            static const Type min();
        };

        /**
         * Specialization for user-defined records.
         *
         *     @param Type  Type of the value elements.
         */
        template<class Type> struct Value<Type, false>
        {
            /**
             * @see Value<Type, num>::max().
             */
            static const Type max();

            /**
             * @see Value<Type, num>::min().
             */
            static const Type min();
        };
    }
}

#include "lib/stxxl/value_impl.hpp"
#endif