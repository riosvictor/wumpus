@echo off
rem Arquivo de compilação dos Agentes do Mundo do Wumpus

@cd ..\src

echo.
echo Gerando Classe Java para a base de regras ...
if exist WumpusKB.rules java -cp ..\Jeops.jar;..\JeopsRE.jar;..\classes jeops.compiler.Main WumpusKB.rules
if exist WumpusInfoKB.rules java -cp ..\Jeops.jar;..\JeopsRE.jar;..\classes jeops.compiler.Main WumpusInfoKB.rules
if exist WumpusComKB.rules java -cp ..\Jeops.jar;..\JeopsRE.jar;..\classes jeops.compiler.Main WumpusComKB.rules
echo ok.

echo.
echo Compilando, aguarde ...
javac -classpath ..\JeopsRE.jar;..\classes -d ..\classes *.java
echo ok.
echo.

@cd ..\scripts