/**
 * binaryreader.hpp - Read plain old data types from binary file.
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
#include <stdexcept>

template<class Type> lib::BinaryReader<Type>::BinaryReader(const std::string& fileName)
        : file(std::fopen(fileName.c_str(), "rb")), buffer_offset(0), max_offset(0)
{
    if (file == 0)
    {
        throw std::runtime_error("Cannot open " + fileName);
    }
}

template<class Type> lib::BinaryReader<Type>::~BinaryReader()
{
    if (std::fclose(file) == EOF)
    {
        throw std::runtime_error("An error occurred while closing binary read file.");
    }
};

template<class Type> inline Type lib::BinaryReader<Type>::read()
{
    if (buffer_offset == max_offset)
    {
        max_offset = std::fread(buffer, sizeof(Type), buffer_size, file);
        if ((max_offset != buffer_offset) && (std::ferror(file) != 0))
        {
            throw std::runtime_error("File error while reading from file.");
        }
        buffer_offset = 0;
    }
    if (buffer_offset == max_offset)
    {
        throw std::runtime_error("Reading after end of file");
    }
    return buffer[buffer_offset++];
}

template<class Type> template<class Other> Other lib::BinaryReader<Type>::read()
{
    Other value;
    Type* buffer = (Type*) &value;
    std::size_t num = sizeof(Other) / sizeof(Type);
    for (Type* end = buffer + num; buffer != end; ++buffer)
    {
        *buffer = read();
    }
    return value;
}