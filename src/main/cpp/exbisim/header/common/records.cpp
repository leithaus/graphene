/**
 * records.cpp - STXXL compatible data records.
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
#include <limits>
#include "common/records.hpp"


const AnnotatedNode AnnotatedNode::max()
{
    const AnnotatedNode max = { std::numeric_limits<uint>::max(),
                                std::numeric_limits<uint>::max(),
                                std::numeric_limits<uint>::max(),
                                std::numeric_limits<uint>::max(),
                                std::numeric_limits<uint>::max() };
    return max;
}

const Edge Edge::max()
{
    const Edge max = { std::numeric_limits<uint>::max(),
                       std::numeric_limits<uint>::max() };
    return max;
}

const Node Node::max()
{
    const Node max = { std::numeric_limits<uint>::max(),
                       std::numeric_limits<uint>::max() };
    return max;
}

const NodeValue NodeValue::max()
{
    const NodeValue max = { std::numeric_limits<uint>::max(),
                            std::numeric_limits<uint>::max() };
    return max;
}

const AnnotatedNode AnnotatedNode::min()
{
    const AnnotatedNode min = { std::numeric_limits<uint>::min(),
                                std::numeric_limits<uint>::min(),
                                std::numeric_limits<uint>::min(),
                                std::numeric_limits<uint>::min(),
                                std::numeric_limits<uint>::min() };
    return min;
}

const Edge Edge::min()
{
    const Edge min = { std::numeric_limits<uint>::min(),
                       std::numeric_limits<uint>::min() };
    return min;
}

const Node Node::min()
{
    const Node min = { std::numeric_limits<uint>::min(),
                       std::numeric_limits<uint>::min() };
    return min;
}

const NodeValue NodeValue::min()
{
    const NodeValue min = { std::numeric_limits<uint>::min(),
                            std::numeric_limits<uint>::min() };
    return min;
}