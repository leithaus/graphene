/**
 * xmlread.hpp - XML reading functions.
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
#ifndef INCLUDE_COMMON_XMLREAD_HPP_
#define INCLUDE_COMMON_XMLREAD_HPP_
#include <map>
#include <string>
#include "common/types.hpp"
#include "libxml/xmlreader.h"

/* The node type for open tags. */
const int OPEN_ELEMENT = 1;

/* The node type for close tags. */
const int CLOSE_ELEMENT = 15;

/**
 * Tag type for generating label id based on some hash of the label name.
 */
struct HashLabel { };

/* C++ STD-style strings for xmlChar character strings. */
typedef std::basic_string<xmlChar> XmlString;

/**
 * Note: all functions processing XML data can cause an XML error; thereby
 * calling the error handler. This error handler can throw an exception of type
 * std::runtime_error (@see error_handler()).
 */

/**
 * Output stream for XML strings.
 *
 *     @param Elem    The character elements stored in the output stream.
 *     @param Traits  Character traits of Elem.
 *     @param out     The output stream to write to.
 *     @param string  The string to write to the output stream.
 *     @return the output stream.
 */
template<class Elem, class Traits>
        std::basic_ostream<Elem, Traits>& operator<<(std::basic_ostream<Elem, Traits>& out,
                                                     const XmlString string);

/**
 * Callback function for the XML parser; called when an error occurs during
 * parsing.
 *
 *     @param arg       The user argument.
 *     @oaram msg       The message received from the parser.
 *     @param severity  Severity of the error.
 *     @param locator   Indication of the location where the error occurs.
 *     @throws std::runtime_error when the XML input is invalid.
 */
void error_handler(void* arg, const char* msg,
                   xmlParserSeverities severity, xmlTextReaderLocatorPtr locator);

/**
 * Read the current name from the reader, and return the label id for this
 * name. The label id is generated by calculating a value dependent on the
 * content of the string. This method is not guaranteed to generate unique
 * label identifiers. The identifiers generated for different labels thus can
 * collide. This method does not have any memory overhead, and thus can be
 * used in all cases independent of the number of labels.
 *
 *     @param reader     Pointer to the current XML reader.
 *     @param label      Tag indicating that hashing should be used.
 *     @param attribute  True if this label is the name of an attribute.
 *     @param log        Pointer to a output stream where to label information
 *                       is logged; NULL if this information does not have to
 *                       be logged.
 *     @return the identifier for the current label.
 */
uint label_id(xmlTextReaderPtr reader, HashLabel& label,
             bool attribute, std::ofstream* log);

/**
 * Read the current name from the reader, and return the label id for this
 * name. A fresh label id is generated when the name does not yet have a label.
 * This method is limited by free memory; only a limited amount of labels can
 * be mapped in memory.
 *
 *     @param reader     Pointer to the current XML reader.
 *     @param label      Mapping between label and label identifier.
 *     @param attribute  True if this label is the name of an attribute.
 *     @param log        Pointer to a output stream where to label information
 *                       is logged; NULL if this information does not have to
 *                       be logged.
 *     @return the identifier for the current label.
 */
uint label_id(xmlTextReaderPtr reader, std::map<XmlString, uint>& labelMap,
              bool attribute, std::ofstream* log);

/**
 * Return the name of the current node in the XML reader. If the name is an
 * attribute name; then the name is prefixed with an '@'.
 *
 *     @param reader     Pointer to the current XML reader.
 *     @param attribute  True if the name is an attribute name.
 *     @return the name of the current node in the XML reader.
 */
XmlString label_name(xmlTextReaderPtr reader, bool attribute);

#endif