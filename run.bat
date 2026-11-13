@echo off
chcp 65001 > nul
cd /d "%~dp0"
title Lab 1 (Variant 5) - Yurash Maksim

if exist "Lab1_Main.class" goto run
echo [INFO] Compiling Java source files...
javac -encoding UTF-8 Task1_NumberSign.java Task2_BubbleSort.java Lab1_Main.java
if errorlevel 1 goto error

:run
java -Dfile.encoding=UTF-8 -cp . Lab1_Main
goto end

:error
echo [ERROR] Compilation failed. Ensure JDK is installed.

:end
pause
