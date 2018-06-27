#!/bin/bash

finalName=$(mvn help:evaluate -Dexpression=project.build.finalName | grep -e "^[^\\[]")

mvn clean install && java -jar target/${finalName}.jar
#mvn exec:java
