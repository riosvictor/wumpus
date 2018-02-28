@echo off
rem Arquivo de inicialização do WumpusMonitor

@cd ..\classes

echo.
echo Inicializando Monitor ...
start /min java -Djava.security.policy=java.security.AllPermission wm.WumpusMonitor localhost 5%1 Monitor %2
echo ok.
echo.

@cd ..\scripts