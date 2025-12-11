@echo off
setlocal

rem Maven Wrapper script for Windows

set MAVEN_HOME=%~dp0.mvn\apache-maven-3.6.3
set MAVEN_OPTS=-Xmx1024m -XX:MaxPermSize=256m

if not exist "%MAVEN_HOME%\bin\mvn" (
    echo "Maven not found. Please install Maven or set MAVEN_HOME."
    exit /b 1
)

"%MAVEN_HOME%\bin\mvn" %* 

endlocal