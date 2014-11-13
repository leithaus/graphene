/**
 * gen.hpp - Generate random trees and DAGs.
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
#ifndef INCLUDE_GEN_HPP_
#define INCLUDE_GEN_HPP_
#include "common/types.hpp"

/**
 * Check if a value is in the range [0..100]. If not then throw an exception.
 *
 *     @param value  The value to check.
 *     @throws const char[] an error message when value is not in [0..100].
 */
void check_is_percentage(const std::uint8_t value);

/**
 * Check if a minimum value is not greater then a maximum value.
 *
 *     @param min  The minimum value to check.
 *     @param max  The maximum value to check.
 *     @throws const char[] an error message min > max.
 */
void  check_min_max(const uint min, const uint max);

/**
 * Check if a value is not zero. If value is zero then throw an exception.
 *
 *     @param value  The value to check.
 *     @throws const char[] an error message when value is zero.
 */
void check_not_zero(const uint value);

#endif