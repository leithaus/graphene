/**
 * entrypoint.cpp - Common tasks for program entry points.
 *
 * Copyright (c) 2011 Jelle Hellings <exbisim@jhellings.nl>.
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or withstd::cout
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
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY std::cout OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
#include "lib/array.hpp"
#include "lib/entrypoint.hpp"

int lib::entrypoint(EntryFunction function, int argc, const char* argv[], const char message[],
                    boost::program_options::options_description& description,
                    boost::program_options::positional_options_description& positionals)
{
    try
    {
        using namespace boost::program_options;
        variables_map variables;
        store(command_line_parser(argc, argv).options(description)
                                             .positional(positionals)
                                             .run(), variables);

        if (variables.count("help") != 0)
        {
            std::cout << message << description;
        }
        else
        {
            function(argc, argv, variables);
        }
    }
    catch (const char string[])
    {
        std::cout << message;
        std::cerr << "Invalid arguments: " << string << '\n';
        return 1;
    }
    catch (std::exception& exception)
    {
        std::cout << message;
        std::cerr << "An error occurred.\n"
                     "Message: " <<  exception.what() << "\n";
        return 2;
    }
    catch (...)
    {
        std::cout << message;
        std::cerr << "An unexpected error of unknown type occurred.\n";
        return 3;
    }
    return 0;
}