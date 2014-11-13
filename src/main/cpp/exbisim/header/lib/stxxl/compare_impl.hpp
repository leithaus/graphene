/**
 * compare_impl.hpp - STXXL-compatible comparison functions.
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
#include "lib/stxxl/value.hpp"

template<class Type, class Function, bool less>
        lib::stxxl::Compare<Type, Function, less>::Compare() :
                cmp(),
                min(less ? Value<Type>::min() : Value<Type>::max()),
                max(less ? Value<Type>::max() : Value<Type>::min()) { }

template<class Type, class Function, bool less>
        lib::stxxl::Compare<Type, Function, less>::Compare(Function cmp) :
                cmp(cmp),
                min(less ? Value<Type>::min() : Value<Type>::max()),
                max(less ? Value<Type>::max() : Value<Type>::min()) { }

template<class Type, class Function, bool less>
        inline bool lib::stxxl::Compare<Type, Function, less>::operator()(const Type& left,
                                                                          const Type& right) const
{
    return cmp(left, right);
}

template<class Type, class Function, bool less>
        const Type& lib::stxxl::Compare<Type, Function, less>::max_value() const
{
    return max;
}

template<class Type, class Function, bool less>
        const Type& lib::stxxl::Compare<Type, Function, less>::min_value() const
{
    return min;
}

template<class Type>
        lib::stxxl::Compare<Type, std::less<Type>, true> lib::stxxl::less()
{
    return less<Type>(std::less<Type>());
}

template<class Type, class Function>
        lib::stxxl::Compare<Type, Function, true> lib::stxxl::less(Function cmp)
{
    return Compare<Type, Function, true>(cmp);
}

template<class Type>
        lib::stxxl::Compare<Type, std::greater<Type>, false> lib::stxxl::greater()
{
    return greater<Type>(std::greater<Type>());
}

template<class Type, class Function>
        lib::stxxl::Compare<Type, Function, false> lib::stxxl::greater(Function cmp)
{
    return Compare<Type, Function, false>(cmp);
}