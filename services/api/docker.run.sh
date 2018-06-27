#!/bin/bash -e
export $(cat ./.env | grep -v ^# | xargs)
docker run -d --rm \
 --env-file ./.env \
 -p $COMPONENT_PARAM_PORT:$COMPONENT_PARAM_PORT \
 -p $COMPONENT_PARAM_PORTS:$COMPONENT_PARAM_PORTS \
  --name ${COMPONENT_KEY} ${COMPONENT_KEY}:${COMPONENT_VERSION}
