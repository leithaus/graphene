/**
 * xmlread.cpp - XML reading functions.
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
#include "common/xmlread.hpp"
#include "lib/hash.hpp"

template<class Elem, class Traits>
        std::basic_ostream<Elem, Traits>& operator<<(std::basic_ostream<Elem, Traits>& out,
                                                     XmlString string)
{
    for (auto it = string.begin(), end = string.end(); it != end; ++it)
    {
        out << (Elem) *it;
    }
    return out;
}

void error_handler(void* arg, const char* msg,
                   xmlParserSeverities severity, xmlTextReaderLocatorPtr locator)
{
    if (severity == XML_PARSER_SEVERITY_ERROR)
    {
        throw std::runtime_error(msg);
    }
}

uint label_id(xmlTextReaderPtr reader, HashLabel& label,
              bool attribute, std::ofstream* log)
{
    lib::Hash<uint> hash;
    XmlString name(label_name(reader, attribute));
    for (auto it = name.begin(), end = name.end(); it != end; ++it)
    {
        hash(*it);
    }
    if (log != 0)
    {
        *log << hash.value() << ' ' << name << '\n';
    }
    return hash.value();
}

uint label_id(xmlTextReaderPtr reader,
              std::map<XmlString, uint>& labelMap,
              bool attribute, std::ofstream* log)
{
    XmlString name(label_name(reader, attribute));
    if (labelMap.find(name) == labelMap.end())
    {
        labelMap[name] = (uint) labelMap.size();
        if (log != 0)
        {
            *log << labelMap[name] << ' ' << name << '\n';
        }
    }
    return labelMap[name];
}

XmlString label_name(xmlTextReaderPtr reader, bool attribute)
{
    const xmlChar* name = xmlTextReaderConstName(reader);
    return (attribute) ? BAD_CAST "@" + XmlString(name) : name;
}