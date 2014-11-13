/**
 * buffer_impl.hpp - Internal/External buffer (vector wrapper).
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

template<class Type> lib::stxxl::Buffer<Type>::Buffer() :
        max_size(std::min(MEMORY_BLOCK, (::stxxl::unsigned_type) 32 * 1024 * 1024) / sizeof(Type)),
        im_vector(), ex_vector(), in_memory(true)
{
    im_vector.reserve(max_size);
}

template<class Type>
        const Type& lib::stxxl::Buffer<Type>::operator[](const std::uint64_t offset) const
{
    return (in_memory) ? im_vector[(std::size_t) offset]
                       : ex_vector[offset];
}

template<class Type> const Type& lib::stxxl::Buffer<Type>::back() const
{
    return (in_memory) ? im_vector.back()
                       : ex_vector.back();
}

template<class Type> void lib::stxxl::Buffer<Type>::clear()
{
    im_vector.clear();
    if (!in_memory)
    {
        ex_vector.resize(0);
        in_memory = true;
    }
}

template<class Type> bool lib::stxxl::Buffer<Type>::empty() const
{
    return (in_memory) ? im_vector.empty()
                       : ex_vector.empty();
}

template<class Type> void lib::stxxl::Buffer<Type>::push_back(const Type& value)
{
    if (in_memory && (im_vector.size() < max_size))
    {
        im_vector.push_back(value);
    }
    else if (in_memory)
    {
        in_memory = false;
        ex_vector.resize(0);
        for (std::size_t i = 0; i < im_vector.size(); ++i)
        {
            ex_vector.push_back(im_vector[i]);
        }
        ex_vector.push_back(value);
    }
    else
    {
        ex_vector.push_back(value);
    }
}

template<class Type> template<class Function>
        void lib::stxxl::Buffer<Type>::sort(Function function)
{
    if (in_memory)
    {
        std::sort(im_vector.begin(), im_vector.end(), function);
    }
    else
    {
        ::stxxl::sort(ex_vector.begin(), ex_vector.end(), function, MEMORY_BLOCK);
    }
}

template<class Type> std::uint64_t lib::stxxl::Buffer<Type>::size() const
{
    return (in_memory) ? im_vector.size() : ex_vector.size();
}