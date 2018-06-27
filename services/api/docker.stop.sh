#!/bin/bash -e
export $(cat ./.env | grep -v ^# | xargs)
docker stop ${COMPONENT_KEY}
docker rmi ${COMPONENT_KEY}:${COMPONENT_VERSION}
