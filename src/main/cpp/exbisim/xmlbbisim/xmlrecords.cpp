/**
 * xmlrecords.cpp - Data records used by backward bisimulation (xml documents).
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
#include "xmlrecords.hpp"

bool operator==(const XmlAnnotateNode& left, const XmlAnnotateNode& right)
{
    return (left.index == right.index);
}

bool operator==(const XmlNodeIdentifier& left, const XmlNodeIdentifier& right)
{
    return (left.rank == right.rank) && (left.index == right.index);
}

bool operator<(const XmlAnnotateEdge& left, const XmlAnnotateEdge& right)
{
    return (left.from < right.from) ||
            ((left.from == right.from) && (left.to < right.to));
}

bool operator<(const XmlAnnotateNode& left, const XmlAnnotateNode& right)
{
    return (left.parent_block < right.parent_block) ||
            ((left.parent_block == right.parent_block) &&
                ((left.label < right.label) ||
                    ((left.label == right.label) && (left.index < right.index))));
}

bool operator<(const XmlEdge& left, const XmlEdge& right)
{
    return (left.from < right.from) ||
            ((left.from == right.from) && (left.to < right.to));
}

bool operator<(const XmlNode& left, const XmlNode& right)
{
    return (left.identifier < right.identifier);
}

bool operator<(const XmlNodeIdentifier& left, const XmlNodeIdentifier& right)
{
    return (left.rank < right.rank) ||
            ((left.rank == right.rank) && (left.index < right.index));
}

bool operator>(const XmlNodeIdentifier& left, const XmlNodeIdentifier& right)
{
    return (left.rank > right.rank) ||
            ((left.rank == right.rank) && (left.index > right.index));
}

bool operator>(const XmlNodePartitionBlock& left, const XmlNodePartitionBlock& right)
{
    return (left.identifier > right.identifier) ||
            ((left.identifier == right.identifier) &&
                (left.partition_block > right.partition_block));
}

const XmlAnnotateEdge XmlAnnotateEdge::max()
{
    XmlAnnotateEdge edge = { XmlAnnotateNode::max(),
                             std::numeric_limits<uint>::max() };
    return edge;
}

const XmlAnnotateEdge XmlAnnotateEdge::min()
{
    XmlAnnotateEdge edge = { XmlAnnotateNode::min(),
                             std::numeric_limits<uint>::min() };
    return edge;
}

const XmlAnnotateNode XmlAnnotateNode::max()
{
    XmlAnnotateNode node = { std::numeric_limits<uint>::max(),
                             std::numeric_limits<uint>::max(),
                             std::numeric_limits<uint>::max() };
    return node;
}

const XmlAnnotateNode XmlAnnotateNode::min()
{
    XmlAnnotateNode node = { std::numeric_limits<uint>::min(), 
                             std::numeric_limits<uint>::min(), 
                             std::numeric_limits<uint>::min() };
    return node;
}

const XmlEdge XmlEdge::max()
{
    XmlEdge edge = { XmlNodeIdentifier::max(),
                     std::numeric_limits<uint>::max() };
    return edge;
}

const XmlEdge XmlEdge::min()
{
    XmlEdge edge = { XmlNodeIdentifier::min(),
                     std::numeric_limits<uint>::min() };
    return edge;
}

const XmlNode XmlNode::max()
{
    XmlNode node = { XmlNodeIdentifier::max(),
                     std::numeric_limits<uint>::max() };
    return node;
}

const XmlNode XmlNode::min()
{
    XmlNode node = { XmlNodeIdentifier::min(),
                     std::numeric_limits<uint>::min() };
    return node;
}

const XmlNodeIdentifier XmlNodeIdentifier::max()
{
    XmlNodeIdentifier node = { std::numeric_limits<uint>::max(),
                               std::numeric_limits<uint>::max() };
    return node;
}

const XmlNodeIdentifier XmlNodeIdentifier::min()
{
    XmlNodeIdentifier node = { std::numeric_limits<uint>::min(),
                               std::numeric_limits<uint>::min() };
    return node;
}


const XmlNodePartitionBlock XmlNodePartitionBlock::max()
{
    XmlNodePartitionBlock block = { XmlNodeIdentifier::max(),
                                    std::numeric_limits<uint>::max() };
    return block;
}

const XmlNodePartitionBlock XmlNodePartitionBlock::min()
{
    XmlNodePartitionBlock block = { XmlNodeIdentifier::min(),
                                    std::numeric_limits<uint>::min() };
    return block;
}