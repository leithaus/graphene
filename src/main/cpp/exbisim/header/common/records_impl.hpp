/**
 * records_impl.hpp - STXXL compatible data records.
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

template<class Type> template<class Function>
        inline bool CountHash<Type>::less(const CountHash<Type>& left,
                                          const CountHash<Type>& right,
                                          Function& cmp)
{
    return (left.count < right.count) ||
            ((left.count == right.count) &&
                ((left.hash < right.hash) ||
                 ((left.hash == right.hash) && cmp(left.value, right.value))));
}

template<class Type> CountHash<Type> const CountHash<Type>::max()
{
    const CountHash<Type> max = { std::numeric_limits<uint>::max(),
                                  std::numeric_limits<uint>::max(),
                                  lib::stxxl::Value<Type>::max() };
    return max;
}

template<class Type> CountHash<Type> const CountHash<Type>::min()
{
    const CountHash<Type> min = { std::numeric_limits<uint>::min(),
                                  std::numeric_limits<uint>::min(),
                                  lib::stxxl::Value<Type>::min() };
    return min;
}

inline bool Edge::less_to(const Edge& left, const Edge& right)
{
    return (left.to < right.to) ||
            ((left.to == right.to) && (left.from < right.from));
}

inline bool operator<(const AnnotatedNode& left, const AnnotatedNode& right)
{
    return (left.rank < right.rank) ||
           ((left.rank == right.rank) && 
                ((left.label < right.label) ||
                 ((left.label == right.label) &&
                    ((left.summary < right.summary) ||
                        ((left.summary == right.summary) &&
                            (left.identifier < right.identifier))))));
}

template<class Type>
        inline bool operator<(const CountHash<Type>& left,
                              const CountHash<Type>& right)
{
    return CountHash<Type>::less(left, right, std::less<Type>());
}

inline bool operator<(const Edge& left, const Edge& right)
{
    return (left.from < right.from) ||
            ((left.from == right.from) && (left.to < right.to));
}

inline bool operator<(const Node& left, const Node& right)
{
    return (left.identifier < right.identifier);
}

inline bool operator<(const NodeValue& left, const NodeValue& right)
{
    return (left.identifier < right.identifier) ||
           ((left.identifier == right.identifier) && (left.value < right.value));
}

inline bool operator>(const NodeValue& left, const NodeValue& right)
{
    return (left.identifier > right.identifier) ||
           ((left.identifier == right.identifier) &&  (left.value > right.value));
}