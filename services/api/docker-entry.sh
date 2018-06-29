#!/bin/sh

SERVICE_API_ARTIFACT=$(ls *.jar)

exec java -Djava.security.egd=file:/dev/./urandom -jar ./${SERVICE_API_ARTIFACT}
