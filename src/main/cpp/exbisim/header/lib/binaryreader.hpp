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
#ifndef INCLUDE_LIB_BINARYREADER_HPP_
#define INCLUDE_LIB_BINARYREADER_HPP_
#include <cstdlib>
#include <string>

namespace lib
{
    /**
     * Class providing sequential write access to a binary file.
     *
     *     @param Type  The plain old data type read from file; this type is
     *                  one-to-one mapped from disk to memory. Thereby binary
     *                  files read by this binary implementation are limited to
     *                  files written in the same memory format.
     */
    template<class Type> class BinaryReader
    {
    public:
        /**
         * Open the binary sequential reader.
         *
         *     @param fileName  The file to open.
         *     @throws std::runtime_error when the file cannot be opened.
         */
        BinaryReader(const std::string& fileName);

        /**
         * Close the file.
         *
         *     @throws std::runtime_error when the file cannot be closed.
         */
        ~BinaryReader();

        /**
         * Return a value from file.
         *
         *     @return value from file.
         *     @throws std::runtime_error when the value cannot be read.
         */
        Type read();

        /**
         * Read value of the specified type from file.
         *
         *     @param Other  Type of the elements to read.
         *     @return value read from file.
         *     @throws std::runtime_error when the values cannot be written.
         *
         * Note:  (sizeof(Other) % sizeof(Type)) = 0. should hold.
         */
        template<class Other> Other read();

    private:
        /* Size of the write buffer. */
        static const std::size_t buffer_size = (1024 * 1024) / sizeof(Type);

        /* The file descriptor representing this file. */
        std::FILE* file;

        /* Write buffer. */
        Type buffer[buffer_size];

        /* Offset in the buffer. */
        std::size_t buffer_offset;

        /* Maximum offset in the buffer. */
        std::size_t max_offset;
    };
}

#include "lib/binaryreader_impl.hpp"
#endif