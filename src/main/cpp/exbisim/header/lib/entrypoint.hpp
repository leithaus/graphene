/**
 * entrypoint.hpp - Common tasks for program entry points.
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
#ifndef INCLUDE_LIB_ENTRYPOINT_HPP_
#define INCLUDE_LIB_ENTRYPOINT_HPP_
#include "boost/program_options.hpp"

namespace lib
{
    /* Pointer to the main entry point of a function. */
    typedef void(*EntryFunction)(int, const char*[],
                                 boost::program_options::variables_map&);


    /**
     * Check if a command line argument is set; return this argument. If the
     * argument is not set; then throw an exception.
     *
     *     @param Type       Type of the command line argument.
     *     @param variables  The command line argument variables map.
     *     @param name       The name of the command line argument.
     *     @throws const char[] an error message when name is not set.
     *     @return the value of the argument.
     */
    template<class Type> Type get_argument(boost::program_options::variables_map variables,
                                           const char name[]);

    /**
     * The entrypoint function handles common tasks for program execution.
     * These tasks are: displaying help messages; catching errors; displaying
     * error messages and returning error codes. The entrypoint function
     * executes the body of a program and catches any errors. The errors are
     * handled in the following way:
     *
     *  - const char* exceptions are handled as messages. These messages are
     *    directly outputted to the user together with message. The value 1 is
     *    returned.
     *  - For std::exceptions a generic error message is displayed. The
     *    exception.what() message is shown. The value 2 is returned.
     *  - For other exceptions the value 3 is returned and a generic exception
     *    message is shown.
     *
     * On correct termination the value 0 is returned.
     *
     *     @param function     The entry point function to execute.
     *     @param argc         The number of command line arguments.
     *     @param argv         The command line arguments.
     *     @param message      The descriptive message of the program.
     *     @param description  The command line argument descriptions.
     *     @param positionals  The command line positional arguments.
     */
    int entrypoint(EntryFunction function, int argc, const char* argv[], const char message[],
                   boost::program_options::options_description& description,
                   boost::program_options::positional_options_description& =
                            boost::program_options::positional_options_description());
}

#include "lib/entrypoint_impl.hpp"
#endif