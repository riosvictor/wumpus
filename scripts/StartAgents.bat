@echo off
rem Arquivo de inicialização do agente explorador do mundo do Wumpus

@cd ..\classes

echo.
if not exist WumpusX.class goto agente
echo Inicializando Wumpus ...
start /min java -cp ..\JeopsRE.jar;.\ WumpusX localhost 5%1 6%1
echo ok.
echo.
:agente
echo Inicializando Agente ...
java -cp ..\JeopsRE.jar;.\ ExplorerX localhost 5%1 3%1
echo ok.

@cd ..\scripts
