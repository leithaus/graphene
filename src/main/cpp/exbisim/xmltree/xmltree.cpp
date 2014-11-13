/**
 * xmltree.cpp - Generate trees from xml documents.
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
#include <fstream>
#include "common/format.hpp"
#include "common/treetag.hpp"
#include "lib/entrypoint.hpp"
#include "lib/hash.hpp"
#include "xmltree.hpp"

/**
 * pd: Note: Note: platform dependent header; needed for open() function to open
 * files. We need this function for a small 'fix' for large file support within
 * libxml2. Other platforms don't need io.h but might need unistd.h for close().
 */
#include <io.h>
#include <fcntl.h>

template<class Label> void process_attributes(xmlTextReaderPtr reader,
                                              Label& label, std::ofstream* log,
                                              lib::BinaryWriter<ubyte>& out)
{
    int attribute = xmlTextReaderMoveToFirstAttribute(reader);
    while (attribute == 1)
    {
        out << TreeTag::OPEN << label_id(reader, label, true, log) << TreeTag::CLOSE;
        attribute = xmlTextReaderMoveToNextAttribute(reader);
    }
    xmlTextReaderMoveToElement(reader);
}

template<class Label> void process_node(xmlTextReaderPtr reader,
                                        Label& label, std::ofstream* log,
                                        lib::BinaryWriter<ubyte>& out)
{
    int type = xmlTextReaderNodeType(reader);
    if (type == OPEN_ELEMENT)
    {
        out << TreeTag::OPEN << label_id(reader, label, false, log);
        process_attributes(reader, label, log, out);
        if (xmlTextReaderIsEmptyElement(reader) == 1)
        {
            out << TreeTag::CLOSE;
        }
    }
    else if (type == CLOSE_ELEMENT)
    {
        out << TreeTag::CLOSE;
    }
}

void xml_to_tree(xmlTextReaderPtr reader, std::ofstream* log,
                 bool hashing, lib::BinaryWriter<ubyte>& out)
{
    xmlTextReaderSetErrorHandler(reader, error_handler, 0);
    out << Format::TREE;

    int node = 0;
    if (hashing)
    {
        HashLabel labelHash;
        while ((node = xmlTextReaderRead(reader)) == 1)
        {
            process_node(reader, labelHash, log, out);
        }
    }
    else
    {
        std::map<XmlString, uint> labelMap;
        while ((node = xmlTextReaderRead(reader)) == 1)
        {
            process_node(reader, labelMap, log, out);
        }
    }
}

void entrypoint(int argc, const char* argv[],
                boost::program_options::variables_map& variables)
{
    std::string file = lib::get_argument<std::string>(variables, "in");
    int fd = open(file.c_str(), O_RDONLY); // Note: for large file size problems.
    xmlTextReaderPtr reader = xmlReaderForFd(fd, file.c_str(), NULL, XML_PARSE_HUGE);

    if (reader == 0)
    {
        throw "Could not open file for XML reading.";
    }

    bool hashing = variables.count("hash") != 0;
    lib::BinaryWriter<ubyte> out(lib::get_argument<std::string>(variables, "out"));
    if (variables.count("label") != 0)
    {
        std::ofstream file(variables["label"].as<std::string>(),
                            std::ios_base::out | std::ios_base::trunc);

        if (!file.good())
        {
            throw "Could not open label file.";
        }

        file.exceptions(std::ios::badbit);
        xml_to_tree(reader, &file, hashing, out);
    }
    else
    {
        xml_to_tree(reader, 0, hashing, out);
    }
    xmlFreeTextReader(reader);
    close(fd);
}

int main(int argc, const char* argv[])
{
    using namespace boost::program_options;
    static const char message[] =
        "Convert an xml tree document into a graph in tree format\n"
        "  xmltree --help\n"
        "  xmltree [--in] arg [--out] arg [[--label] arg] [--hash]\n\n";

    options_description description("Allowed options");
    description.add_options()
            ("help,h", "produce help")
            ("in,i", value<std::string>(),
                "the file to read the XML document from")
            ("out,o", value<std::string>(),
                "the file to write the graph to (in tree format)")
            ("label,l", value<std::string>(),
                    "optional file to write the assigned labels to; this file "
                    "will contain one entry (label identifier, tag name) for "
                    "every node in the xml tree when hashing is used; it will "
                    "contain one entry (label identifier, tag name) for every "
                    "label when hashing is not used")
            ("hash", "this flag enables hashing to convert XML tag names "
                    "into label identifiers; by default every unique tag name"
                    "is converted to a unique label, but this mapping can "
                    "become to large for graphs with many different tag names");

    positional_options_description positionals;
    positionals.add("in", 1);
    positionals.add("out", 1);
    positionals.add("label", 1);

    return lib::entrypoint(entrypoint, argc, argv, message, description, positionals);
}