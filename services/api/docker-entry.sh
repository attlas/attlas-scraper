#!/bin/sh

COMPONENT_PARAM_ARTIFACT=$(ls *.jar)
exec java -Djava.security.egd=file:/dev/./urandom -jar ./${COMPONENT_PARAM_ARTIFACT}
