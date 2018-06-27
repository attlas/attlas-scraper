#!/bin/bash -e
export $(cat ./.env | grep -v ^# | xargs)
finalName=$(mvn help:evaluate -Dexpression=project.build.finalName | grep -e "^[^\\[]")

docker build \
  --build-arg COMPONENT_PARAM_HOST=${COMPONENT_PARAM_HOST} \
  --build-arg COMPONENT_PARAM_LSTN=${COMPONENT_PARAM_LSTN} \
  --build-arg COMPONENT_PARAM_PORT=${COMPONENT_PARAM_PORT} \
  --build-arg COMPONENT_PARAM_PORTS=${COMPONENT_PARAM_PORTS} \
  --build-arg COMPONENT_PARAM_ARTIFACT=${finalName}.jar \
  -t ${COMPONENT_KEY}:${COMPONENT_VERSION} .
