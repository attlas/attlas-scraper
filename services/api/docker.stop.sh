#!/bin/bash -e

export $(cat ./../../.env | grep -v ^# | xargs)

docker stop ${SERVICE_API_KEY}
docker rmi ${SERVICE_API_KEY}:${PROJECT_VERSION}
