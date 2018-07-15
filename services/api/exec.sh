#!/bin/bash

./build.sh
finalName=$(mvn help:evaluate -Dexpression=project.build.finalName | grep -e "^[^\\[]")
java -jar target/${finalName}.jar
