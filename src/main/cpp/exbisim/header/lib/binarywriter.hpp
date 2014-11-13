/**
 * binarywriter.hpp - Write plain old data types to binary file.
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
#ifndef INCLUDE_LIB_BINARYWRITER_HPP_
#define INCLUDE_LIB_BINARYWRITER_HPP_
#include <cstdlib>
#include <string>

namespace lib
{
    /**
     * Class providing sequential write access to a binary file.
     */
    template<class Type> class BinaryWriter
    {
    public:
        /**
         * Open the binary sequential writer.
         *
         *     @param fileName  The file to open.
         *     @throws std::runtime_error when the file cannot be opened.
         */
        BinaryWriter(const std::string& fileName);

        /**
         * Close the file; write any pending changes to disk.
         *
         *     @throws std::runtime_error when the file cannot be closed or when
         *                                a write error occurs.
         */
        ~BinaryWriter();

        /**
         * Write a binary value to the file.
         *
         *     @param value  The value to write.
         *     @throws std::runtime_error when the value cannot be written.
         */
        BinaryWriter& operator<<(const Type& value);

        /**
         * Write value of the specified type to the file.
         *
         *     @param Other  Type of the elements to read.
         *     @param value  Write value of another type to the file. The size
         *                   of the other type should be a multiple of the type
         *                   of this write buffer.
         *     @throws std::runtime_error when the values cannot be written.
         *
         * Note:  (sizeof(Other) % sizeof(Type)) = 0. should hold.
         */
        template<class Other> BinaryWriter& operator<<(const Other& value);

    private:
        /* Size of the write buffer. */
        static const std::size_t buffer_size = 1024 * 1024 / sizeof(Type);

        /* The file descriptor representing this file. */
        std::FILE* file;

        /* Write buffer. */
        Type buffer[buffer_size];

        /* Offset in the buffer. */
        std::size_t buffer_offset;
    };
}

#include "lib/binarywriter_impl.hpp"
#endif