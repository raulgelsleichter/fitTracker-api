#!/bin/sh
set -e

MAVEN_WRAPPER_VERSION=0.5.6

# Determine the directory of this script
DIR="$(cd "$(dirname "$0")" && pwd)"

# Download the Maven wrapper jar if it doesn't exist
if [ ! -f "$DIR/.mvn/wrapper/maven-wrapper.jar" ]; then
  mkdir -p "$DIR/.mvn/wrapper"
  curl -o "$DIR/.mvn/wrapper/maven-wrapper.jar" "https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/$MAVEN_WRAPPER_VERSION/maven-wrapper-$MAVEN_WRAPPER_VERSION.jar"
fi

# Execute Maven with the provided arguments
exec java -cp "$DIR/.mvn/wrapper/maven-wrapper.jar" org.apache.maven.wrapper.MavenWrapperMain "$@"