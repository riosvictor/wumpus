@echo off
rem Arquivo de inicialização do WumpusServer

@cd ..\classes

echo.
echo Inicializando Servidor ...
start "Server %1" /min java ws.WumpusServer 4%1 5%1 -W:8 -H:8 -e:1000 -k:1000 -P:0.15 -t:1000 -n:1000
echo ok.
echo.

@cd ..\scripts
