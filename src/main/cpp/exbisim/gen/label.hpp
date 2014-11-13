/**
 * label.hpp - Label generator interface.
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
#ifndef INCLUDE_LABEL_HPP_
#define INCLUDE_LABEL_HPP_
#include <cstddef>
#include <random>
#include "common/types.hpp"
#include "lib/array.hpp"

/**
 * Generate labels interface.
 */
class Label
{
public:
    /**
     * Construct a label generator.
     *
     *     @param labels  Number of labels per group.
     *     @param groups  Number of groups of labels.
     */
    Label(const uint labels, const std::size_t groups);

    /**
     * Generate a label. The returned label will be in the range [i * labels,
     * (i + 1) * labels) where i is the group number derived from parameter n
     * such that i = n % groups. The parameter n can be used as a simple
     * control parameter. Thereby the parameter n can introduce structure in
     * the generated labels.
     *
     *     @param n  A simple numeric property of the node.
     *     @return the random label.
     */
    uint generate(const uint n);

private:
    /* The pseudo random number generator. */
    std::mt19937& generator;

    /* The pseudo random distributions for each group. */
    lib::Array<std::uniform_int<uint>> distributions;

    /* Total number of groups. */
    const std::size_t groups;
};

#endif