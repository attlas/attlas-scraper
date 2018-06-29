#!/bin/bash -e
export $(cat ./../../.env | grep -v ^# | xargs)

docker build \
  --build-arg SERVICE_API_HOST=${SERVICE_API_HOST} \
  --build-arg SERVICE_API_LSTN=${SERVICE_API_LSTN} \
  --build-arg SERVICE_API_PORT=${SERVICE_API_PORT} \
  --build-arg SERVICE_API_PORTS=${SERVICE_API_PORTS} \
  -t ${SERVICE_API_KEY}:${PROJECT_VERSION} .
