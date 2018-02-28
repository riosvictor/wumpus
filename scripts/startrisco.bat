@echo off

@cd ..\classes

echo.
echo Inicializando Servidor ...
start "Server %1" /min java ws.WumpusServer 4%1 5%1 -W:8 -H:8 -e:1000 -k:1000 -P:0.2 -t:1000 -n:1000
echo ok.

echo.
echo Inicializando Monitor ...
start /min java wm.WumpusMonitor localhost 5%1 Monitor
echo ok.

echo Aguarde que a Tela do Ambiente seja Iniciada ...
pause()

echo.
echo Inicializando Agente ...
java -cp ..\JeopsRE.jar;.\ ExplorerX localhost 5%1 3%1 %2
echo ok.

@cd ..\scripts
