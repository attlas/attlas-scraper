#!/bin/bash -e

export $(cat ./../../.env | grep -v ^# | xargs)

docker run -d --rm \
 --env-file ./../../.env \
 -p $SERVICE_API_PORT:$SERVICE_API_PORT \
 -p $SERVICE_API_PORTS:$SERVICE_API_PORTS \
  --name ${SERVICE_API_KEY} ${SERVICE_API_KEY}:${PROJECT_VERSION}
