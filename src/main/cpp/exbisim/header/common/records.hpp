/**
 * records.hpp - STXXL compatible data records.
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
#ifndef INCLUDE_COMMON_RECORD_HPP_
#define INCLUDE_COMMON_RECORD_HPP_
#include "common/types.hpp"
#include "lib/stxxl/compare.hpp"

/**
 * The data records provided in this file are all STXXL compatible data records
 * used by one or more applications. Each data record is defined as a plain old
 * data type.
 *
 * For most data records we have defined operator< (for comparisons) and static
 * members min(), max() returning the minimum and maximum possible value for the
 * record. These are used for creating STXXL compatible ordering functions (used
 * by stxxl::sort and others).
 *
 *     @see lib/stxxl/compare.hpp for details on ordering functions.
 */

/**
 * Node record containing annotation for each node (rank, label, structural
 * summary) together with node identifier and number of parent nodes the node
 * has.
 */
struct AnnotatedNode
{
    /* The rank of the node. */
    uint rank;

    /* The label of the node. */
    uint label;

    /* The structural summary of the node. */
    uint summary;

    /* The node identifier. */
    uint identifier;

    /* The number of parent nodes this node has. */
    uint parents;

    /**
     * @see common description.
     */
    static const AnnotatedNode max();

    /**
     * @see common description.
     */
    static const AnnotatedNode min();
};

/**
 * The count hash structure wraps some value (normally related to some node) and
 * adds some count (normally the number of different partition blocks wherein
 * children of a node are placed) and a hash value (normally calculated over the
 * different partition blocks wherein children of a node are placed).
 *
 *     @param Type  Type of the value elements stored in this structure.
 */
template<class Type> struct CountHash
{
    /* The count-value. */
    uint count;

    /* The hash-value. */
    uint hash;

    /* The value where over the count and hash are calculated. */
    Type value;

    /**
     * Compare this count-hash structure based on the count and hash. When count
     * and hash values are equal then some provided operator is used to compare
     * the values.
     *
     *     @param Function  Type of the comparator function.
     *     @param left      The other value to compare with.
     *     @param right     The other value to compare with.
     *     @param cmp       The comparator function for Type values.
     */
    template<class Function> static bool less(const CountHash<Type>& left,
                                              const CountHash<Type>& right,
                                              Function& cmp);

    /**
     * @see common description.
     */
    static const CountHash<Type> max();

    /**
     * @see common description.
     */
    static const CountHash<Type> min();
};

/**
 * Edge record for edge (from, to).
 */
struct Edge
{
    /* The identifier of the parent node. */
    uint from;

    /* The identifier of the child node. */
    uint to;

    /**
     * Return true if the left edge value should be lexicographically ordered
     * before the right edge value; when both edges are reversed.
     *
     *     @param left   The left node value.
     *     @param right  The right node.
     *     @return true if reversed left edge is lexicographically smaller than
     *                  reversed right edge.
     */
    static bool less_to(const Edge& left, const Edge& right);

    /**
     * @see common description.
     */
    static const Edge max();

    /**
     * @see common description.
     */
    static const Edge min();
};

/**
 * Node record containing identifier and label.
 */
struct Node
{
    /* The node identifier. */
    uint identifier;

    /* The node label. */
    uint label;

    /**
     * @see common description.
     */
    static const Node max();

    /**
     * @see common description.
     */
    static const Node min();
};

/**
 * General record for (node, value) pairs.
 */
struct NodeValue
{
    /* The node identifier. */
    uint identifier;

    /* The 64-bit value assigned to the node. */
    uint value;

    /**
     * @see common description.
     */
    static const NodeValue max();

    /**
     * @see common description.
     */
    static const NodeValue min();
};

/**
 * Pair of partition block identifier and node identifier used to map nodes to
 * partition blocks.
 */
struct PartitionNodePair
{
    /* The partition block identifier. */
    uint partition;

    /* The node identifier. */
    uint identifier;
};

/**
 * Node record containing annotation for each node (rank, label, structural
 * summary hash) together with node identifier and number of parent nodes the
 * node has.
 */
struct RankLabelNode
{
    /* The rank of the node. */
    uint rank;

    /* The label of the node. */
    uint label;

    /* The node identifier. */
    uint identifier;

    /* The number of parent nodes this node has. */
    uint parents;

    /**
     * @see common description.
     */
    static const RankLabelNode max();

    /**
     * @see common description.
     */
    static const RankLabelNode min();
};

/**
 * Node record (from, to) mapping a node identifier from to a node identifier
 * to.
 */
typedef Edge NodeRenumber;

/**
 * Return true if the left node should be lexicographically ordered before the
 * right node.
 *
 *     @param Type   Type of the value elements stored in this structure.
 *     @param left   The left node.
 *     @param right  The right node.
 *     @return true if left is lexicographically smaller than right.
 */
template<class Type>
        bool operator<(const CountHash<Type>& left, const CountHash<Type>& right);

/**
 * Return true if the left node should be lexicographically ordered before the
 * right node.
 *
 *     @param left   The left node with rank and label.
 *     @param right  The right node with rank and label.
 *     @return true if left is lexicographically smaller than right.
 */
bool operator<(const AnnotatedNode& left, const AnnotatedNode& right);

/**
 * Return true if the left edge should be lexicographically ordered before the
 * right edge.
 *
 *     @param left   The left edge.
 *     @param right  The right edge.
 *     @return true if left is lexicographically smaller than right.
 */
bool operator<(const Edge& left, const Edge& right);

/**
 * Return true if the left node should be lexicographically ordered before the
 * right node.
 *
 *     @param left   The left node.
 *     @param right  The right node.
 *     @return true if left is lexicographically smaller than right.
 */
bool operator<(const Node& left, const Node& right);

/**
 * Return true if the right node value should be lexicographically ordered
 * before the left node value.
 *
 *     @param left   The left node value.
 *     @param right  The right node value.
 *     @return true if left is lexicographically greater than right.
 */
bool operator>(const NodeValue& left, const NodeValue& right);

#include "common/records_impl.hpp"
#endif