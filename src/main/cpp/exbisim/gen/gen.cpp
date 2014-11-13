/**
 * gen.cpp - Generate random trees and DAGs.
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
#include <ctime>
#include <string>
#include "lib/entrypoint.hpp"
#include "generators.hpp"
#include "label.hpp"
#include "gen.hpp"
#include "random.hpp"

void check_is_percentage(std::uint8_t value)
{
    if (value > 100)
    {
        throw "Percentage is not in the range (0..100).";
    }
}

void  check_min_max(uint min, uint max)
{
    if (min > max)
    {
        throw "Maximum is smaller than minimum.";
    }
}

void check_not_zero(uint value)
{
    if (value == 0)
    {
        throw "Value is zero.";
    }
}

void entrypoint(int argc, const char* argv[],
                boost::program_options::variables_map& variables)
{
    using namespace lib;
    using namespace std;

    string format = get_argument<string>(variables, "format");
    string variant = get_argument<string>(variables, "variant");
    size_t groups = get_argument<size_t>(variables, "groups");
    uint labels = get_argument<uint>(variables, "labels");
    Label label(labels, groups);

    unsigned long seed = get_argument<unsigned long>(variables, "seed");
    while (seed == 0)
    {
        seed = (unsigned long) std::time(0);
    }
    random_generator().seed(seed);
    if (format == "dag")
    {
        BinaryWriter<uint> out(lib::get_argument<std::string>(variables, "out"));
        if (variant == "chaintc")
        {
            uint length = get_argument<uint>(variables, "length");
            uint num = get_argument<uint>(variables, "num");
            dag_chaintc(label, length, num, out);
        }
        else if (variant == "random")
        {
            uint nodes = get_argument<uint>(variables, "nodes");
            unsigned int edge = get_argument<unsigned int>(variables, "edge");
            check_is_percentage(edge);
            dag_random(label, nodes, edge, out);
        }
        else if (variant == "pickedge")
        {
            uint nodes = get_argument<uint>(variables, "nodes");
            unsigned int edge = get_argument<unsigned int>(variables, "edge");
            check_is_percentage(edge);
            dag_pickedge(label, nodes, edge, out);
        }
        else
        {
            throw "Unknown variant for dags.";
        }
    }
    else if (format == "tree")
    {
        BinaryWriter<ubyte> out(lib::get_argument<std::string>(variables, "out"));
        if (variant == "chain")
        {
            uint length = get_argument<uint>(variables, "length");
            uint num = get_argument<uint>(variables, "num");
            check_not_zero(length);
            tree_chain(label, length, num, out);
        }
        else if (variant == "random")
        {
            uint nodes = get_argument<uint>(variables, "nodes");
            unsigned int child = get_argument<unsigned int>(variables, "child");
            check_not_zero(nodes);
            check_is_percentage(child);
            tree_random(label, nodes, child, out);
        }
        else
        {
            throw "Unknown variant for trees."; 
        }
    }
    else
    {
        throw "Unknown format.";
    }
}

int main(int argc, const char* argv[])
{
    using namespace boost::program_options;
    static const char message[] =
        "Generate random trees and DAGs according to predefined parameters\n"
        "  gen --help\n"
        "  gen [--out] arg\n"
        "      [--format] arg [--variant] arg ... \n"
        "      [--groups arg] [--labels arg] [--seed arg]\n\n"
        "Valid combinations of format, variation and other options are:\n"
        "  gen file tree random --nodes arg --child arg\n"
        "  gen file tree chain --length arg --num arg\n"
        "  gen file dag random --nodes arg --edge arg\n"
        "  gen file dag chaintc --length arg --num arg\n"
        "  gen file dag pickedge --nodes arg --edge arg\n";

    options_description description("Allowed options");
    description.add_options()
            ("help,h", "produce help")
            ("out,o", value<std::string>(),
                "the file to write the graph to (in dag, dagfp or tree format)")
            ("format,f", value<std::string>(), "the output format of the "
                    "generated graph, possible values are `tree', `dag' and `dagfp'")
            ("variant,v", value<std::string>(), "with the variant one "
                    "specifies specialized generators for graphs with a "
                    "specific structure; possible values are:\n"
                    "  `ran\tdom' (for trees) generate a random tree; whereby "
                    "at each non root node the generator tries to add children "
                    "with probability child%\n"
                    "  `cha\tin' generates a single root node with num chains "
                    "of nodes of length length connected to this root\n"
                    "  `ran\tdom' (for dag and dagfp format)  generate a "
                    " random dag; whereby at each node the generator tries to "
                    "add edges to previously created nodes with probability "
                    "edge%\n"
                    "  `cha\tintc' generates num transitive closure chains; in "
                    "a transitive closure chain every node has an edge to "
                    "every possible descending node\n"
                    "  `pickedge' generates a graph wherein each node shall "
                    "try to create an edge to every node before it; every edge "
                    "has probability edge% to be constructed.")
            ("groups,g", value<std::size_t>()->default_value(1),
                    "number of groups of labels")
            ("labels,l", value<uint>()->default_value(100),
                    "number of labels per group")
            ("seed,s",  value<unsigned long>()->default_value(0),
                    "set the seed for the random number generator to a fixed "
                    "value, when the seed is not specified or when the seed is "
                    "zero a value derived from the current time is used");

    options_description specific("Variant-specific options");
    specific.add_options()
            ("child", value<unsigned int>(), "probability on generating "
                    "children in percent (0..100), see --variant")
            ("edge", value<unsigned int>(), "probability on generating edges "
                    "in percent (0..100), see --variant")
            ("length", value<uint>(), "length, see --variant")
            ("nodes", value<uint>(), "total number of nodes in the "
                    "generated graph, see --variant")
            ("num", value<uint>(), "total number of generated "
                    "structures, see --variant");
    description.add(specific);

    positional_options_description positionals;
    positionals.add("out", 1);
    positionals.add("format", 1);
    positionals.add("variant", 1);

    return lib::entrypoint(entrypoint, argc, argv, message, description, positionals);
}