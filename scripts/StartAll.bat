@echo off

@cd ..\classes

echo.
echo Inicializando Servidor ...
start "Server %1" /min java ws.WumpusServer 4%1 5%1 -W:8 -H:8 -e:1000 -w:1000 -k:1000 -P:0.15 -t:1000 -n:1000
echo ok.

echo.
echo Inicializando Monitor ...
start /min java wm.WumpusMonitor localhost 5%1 Monitor %2
echo ok.

echo Aguarde que a Tela do Ambiente seja Iniciada ...
pause()

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
