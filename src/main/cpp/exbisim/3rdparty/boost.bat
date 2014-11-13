@echo off
echo Boost (bootstrap)
call bootstrap
echo Boost (win32, release)
.\bjam  --toolset=msvc --prefix=%1\boost\win32\release --stagedir=%1\boost\win32\release --build-dir=%1\building\win32\release variant=release threading=multi link=static runtime-link=shared address-model=32 -j 4
echo Boost (win32, debug)
.\bjam --toolset=msvc --prefix=%1\boost\win32\debug --stagedir=%1\boost\win32\debug --build-dir=%1\building\win32\debug variant=debug threading=multi link=static runtime-link=shared address-model=32 -j 4
echo Boost (x64, release)
.\bjam --toolset=msvc --prefix=%1\boost\x64\release --stagedir=%1\boost\x64\release --build-dir=%1\building\x64\release variant=release threading=multi link=static runtime-link=shared address-model=64 -j 4
echo Boost (x64, debug)
.\bjam --toolset=msvc --prefix=%1\boost\x64\debug --stagedir=%1\boost\x64\debug --build-dir=%1\building\x64\debug variant=debug threading=multi link=static runtime-link=shared address-model=64 -j 4