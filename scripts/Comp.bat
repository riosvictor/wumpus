@echo off
rem Arquivo de compila��o dos Agentes do Mundo do Wumpus

@cd ..\src

echo.
echo Complilando, arguade ...
javac -classpath ..\JeopsRE.jar;..\classes;. -d ..\classes *.java
echo ok.
echo.

@cd ..\scripts
