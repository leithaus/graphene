/**
 * generators.cpp - Generators for random trees and DAGs.
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
#include <set>
#include <vector>
#include "common/format.hpp"
#include "common/treetag.hpp"
#include "generators.hpp"
#include "random.hpp"

void dag_chaintc(Label& label, const uint length, const uint num,
                 lib::BinaryWriter<uint>& out)
{
    out << Format::DAG << (length * num);
    for (uint chain = 0, id = 0; chain < num; ++chain)
    {
        uint leaf = id;
        for (uint rank = 0; rank < length; ++rank, ++id)
        {
            out << label.generate(rank) << rank;
            for (uint child = leaf; child < id; ++child)
            {
                out << child;
            }
        }
    }
}

void dag_pickedge(Label& label, const uint nodes, const unsigned int edge,
                  lib::BinaryWriter<uint>& out)
{
    std::mt19937& generator = random_generator();
    std::uniform_int<uint> random(0, std::numeric_limits<uint>::max());

    out << Format::DAG << nodes;
    for (uint i = 0; i < nodes; ++i)
    {
        std::vector<uint> edges;
        for (uint j = 0; j < i; ++j)
        {
            if (random(generator, 99) <= edge)
            {
                edges.push_back(j);
            }
        }
        out << label.generate((uint) edges.size()) << (uint) edges.size();

        for (auto it = edges.begin(), end = edges.end(); it != end; ++it)
        {
            out << *it;
        }
    }
}

void dag_random(Label& label, const uint nodes, const unsigned int edge,
                lib::BinaryWriter<uint>& out)
{
    std::mt19937& generator = random_generator();
    std::uniform_int<uint> random(0, std::numeric_limits<uint>::max());

    out << Format::DAG << nodes;
    for (uint i = 0; i < nodes; ++i)
    {
        std::set<uint> edges;
        while (((edges.size() + 1) < i) && (random(generator, 99) <= edge))
        {
            edges.insert(random(generator, i - 1));
        }
        out << label.generate((uint) edges.size()) << (uint) edges.size();

        for (auto it = edges.begin(), end = edges.end(); it != end; ++it)
        {
            out << *it;
        }
    }
}

void tree_chain(Label& label, const uint length, const uint num,
                lib::BinaryWriter<ubyte>& out)
{
    out << Format::TREE << TreeTag::OPEN << label.generate(0);
    for (uint chain = 0, id = 0; chain < num; ++chain)
    {
        for (uint depth = 1; depth < length; ++depth, ++id)
        {
            out << TreeTag::OPEN << label.generate(depth);
        }
        for (uint depth = 1; depth < length; ++depth, ++id)
        {
            out << TreeTag::CLOSE;
        }
    }   
    out << TreeTag::CLOSE;
}

void tree_random(Label& label, const uint nodes, const unsigned int child,
                 lib::BinaryWriter<ubyte>& out)
{
    std::mt19937& generator = random_generator();
    std::uniform_int<unsigned int> random(0, std::numeric_limits<unsigned int>::max());

    out << Format::TREE;
    uint depth = 0;
    for (uint i = 0; i < nodes; ++i)
    {
        while ((depth > 1) && (random(generator, 99) <= child))
        {
            out << TreeTag::CLOSE;
            --depth;
        }
        out << TreeTag::CLOSE << label.generate(depth);
        ++depth;
    }
    for (uint i = 0; i < depth; ++i)
    {
        out << TreeTag::CLOSE;
    }
}