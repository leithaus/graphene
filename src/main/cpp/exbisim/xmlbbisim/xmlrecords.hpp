/**
 * xmlrecords.hpp - Data records used by backward bisimulation (xml documents).
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
#ifndef INCLUDE_XMLRECORDS_HPP_
#define INCLUDE_XMLRECORDS_HPP_
#include "common/types.hpp"

struct XmlAnnotateEdge;
struct XmlAnnotateNode;
struct XmlEdge;
struct XmlNode;
struct XmlNodeIdentifier;
struct XmlNodePartitionBlock;
struct XmlPartitionNodePair;

/**
 * Node annotated with all information needed for construction node-decision
 * key.
 */
struct XmlAnnotateNode
{
    /* The partition block wherein the parent element is placed (of the parent
     * of the from-node in the (from, to) edge). */
    uint parent_block;

    /* The label of the from-node. */
    uint label;

    /* The index of the from-node. */
    uint index;

    /**
     * @see common description in common/records.hpp.
     */
    static const XmlAnnotateNode max();

    /**
     * @see common description in common/records.hpp.
     */
    static const XmlAnnotateNode min();
};

/**
 * Edge to children for annotated nodes.
 */
struct XmlAnnotateEdge
{
    /* The parent node. */
    XmlAnnotateNode from;

    /* The index of the child node. */
    uint to;

    /**
     * @see common description in common/records.hpp.
     */
    static const XmlAnnotateEdge max();

    /**
     * @see common description in common/records.hpp.
     */
    static const XmlAnnotateEdge min();
};

/**
 * The identifier of nodes representing xml elements. The node identifier is the
 * rank of the node and a unique numeric identifier within the group of all
 * nodes with the same rank.
 */
struct XmlNodeIdentifier
{
    /* The rank of the element in the xml document. */
    uint rank;

    /* The index of this node with respect to the other nodes with same rank. */
    uint index;

    /**
     * @see common description in common/records.hpp.
     */
    static const XmlNodeIdentifier max();

    /**
     * @see common description in common/records.hpp.
     */
    static const XmlNodeIdentifier min();
};

/**
 * Edge representation of parent-child relation between xml elements.
 */
struct XmlEdge
{
    /* The node identifier of the parent element. */
    XmlNodeIdentifier from;

    /* The node identifier of the child element. */
    uint to;

    /**
     * @see common description in common/records.hpp.
     */
    static const XmlEdge max();

    /**
     * @see common description in common/records.hpp.
     */
    static const XmlEdge min();
};

/**
 * Node representation of an xml element.
 */
struct XmlNode
{
    /* The node identifier of this node. */
    XmlNodeIdentifier identifier;

    /* The label of the element. */
    uint label;

    /**
     * @see common description in common/records.hpp.
     */
    static const XmlNode max();

    /**
     * @see common description in common/records.hpp.
     */
    static const XmlNode min();
};

/**
 * Data structure used to send partition blocks from parents to children using a
 * priority queue.
 */
struct XmlNodePartitionBlock
{
    /* The node identifier of the parent element. */
    XmlNodeIdentifier identifier;

    /* The partition block wherein the parent is placed. */
    uint partition_block;

    /**
     * @see common description in common/records.hpp.
     */
    static const XmlNodePartitionBlock max();

    /**
     * @see common description in common/records.hpp.
     */
    static const XmlNodePartitionBlock min();
};

/**
 * Pair of partition block identifier and node identifier used to map nodes to
 * partition blocks.
 */
struct XmlPartitionNodePair
{
    /* The partition block wherein the parent is placed. */
    uint partition_block;

    /* The node identifier of the parent element. */
    XmlNodeIdentifier identifier;
};

/**
 * Return true if the left annotated node is equivalent to the right annotated
 * node.
 *
 *     @param left   The left annotated node.
 *     @param right  The right annotated node.
 *     @return true if left is equivalent to right.
 */
bool operator==(const XmlAnnotateNode& left, const XmlAnnotateNode& right);

/**
 * Return true if the left node identifier is equivalent to the right node
 * identifier.
 *
 *     @param left   The left node identifier.
 *     @param right  The right node identifier.
 *     @return true if left is equivalent to right.
 */
bool operator==(const XmlNodeIdentifier& left, const XmlNodeIdentifier& right);

/**
 * Return true if the left annotated edge should be lexicographically ordered
 * before the right annotated edge.
 *
 *     @param left   The left annotated node.
 *     @param right  The right annotated node.
 *     @return true if left is lexicographically less than right.
 */
bool operator<(const XmlAnnotateEdge& left, const XmlAnnotateEdge& right);

/**
 * Return true if the left annotated node should be lexicographically ordered
 * before the right annotated node.
 *
 *     @param left   The left annotated node.
 *     @param right  The right annotated node.
 *     @return true if left is lexicographically less than right.
 */
bool operator<(const XmlAnnotateNode& left, const XmlAnnotateNode& right);

/**
 * Return true if the left edge value should be lexicographically ordered
 * before the right edge value.
 *
 *     @param left   The left edge value.
 *     @param right  The right edge value.
 *     @return true if left is lexicographically less than right.
 */
bool operator<(const XmlEdge& left, const XmlEdge& right);

/**
 * Return true if the left node value should be lexicographically ordered
 * before the right node value.
 *
 *     @param left   The left node value.
 *     @param right  The right node value.
 *     @return true if left is lexicographically less than right.
 */
bool operator<(const XmlNode& left, const XmlNode& right);

/**
 * Return true if the left node identifier should be lexicographically ordered
 * before the right node identifier.
 *
 *     @param left   The left node identifier.
 *     @param right  The right node udentifier.
 *     @return true if left is lexicographically less than right.
 */
bool operator<(const XmlNodeIdentifier& left, const XmlNodeIdentifier& right);

/**
 * Return true if the right node identifier should be lexicographically ordered
 * before the left node identifier.
 *
 *     @param left   The left node identifier.
 *     @param right  The right node identifier.
 *     @return true if left is lexicographically greater than right.
 */
bool operator>(const XmlNodeIdentifier& left, const XmlNodeIdentifier& right);

/**
 * Return true if the right node partition block should be lexicographically
 * ordered before the left node partition block.
 *
 *     @param left   The left node partition block.
 *     @param right  The right node partition block.
 *     @return true if left is lexicographically greater than right.
 */
bool operator>(const XmlNodePartitionBlock& left, const XmlNodePartitionBlock& right);

#endif