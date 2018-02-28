@echo off
rem Arquivo de compilação do WumpusServer e WumpusMonitor

@cd ..\src

echo.
echo Iniciando compilacao ...
echo Compilando WumpusServer, aguarde ...
javac -d ..\classes ws\*.java
javac -d ..\classes ws\agents\*.java
echo ok.
echo.

echo.
echo Copiando figuras, aguarde ...
@copy *.gif ..\classes
echo ok.
echo.

echo.
echo Compilando WumpusMonitor, aguarde ...
javac -d ..\classes wm\*.java
echo ok.
echo.

echo.
echo Criando stubs e skeletons, aguarde ...
rmic -d ..\classes -keep wm.WumpusMonitor
echo ok.
echo.

@cd ..\scripts