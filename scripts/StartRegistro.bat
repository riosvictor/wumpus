@echo off
rem Arquivo de inicializa��o do RMIRegistry

@cd ..\classes

echo.
echo Inicializando rmiregistry...
start /min rmiregistry %1
echo ok.
echo.

@cd ..\scripts