@echo off
REM Defina o caminho do JAVA e do JEOPS a seguir
REM ===============================================
set JAVAHOME=D:\Arquivos de Programas\Java\jdk1.8.0
set JEOPSHOME=..
REM ==========================================================================
REM Não altere as linhas abaixo a menos que tenha certeza do que está fazendo
REM===========================================================================
set path=%JAVAHOME%\bin;%path%
set classpath=.;%JEOPSHOME%\jeops.jar;%JEOPSHOME%\jeopsre.jar;%JAVAHOME%\lib\tools.jar;%JAVAHOME%\lib\dt.jar;%JAVAHOME%\lib\ant-javafx.jar;%JAVAHOME%\lib\javafx-doclet.jar;%JAVAHOME%\lib\javafx-mx.jar;%JAVAHOME%\lib\jconsole.jar;%JAVAHOME%\lib\sa-jdi.jar
