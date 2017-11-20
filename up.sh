#!/bin/bash

envFile="./.env"

if [ -f "$envFile" ]
then
  . $envFile

  # -----------------------
  # configure load balancer
  rm -rf ./cidd/lb/dist
  mkdir ./cidd/lb/dist
  cp ./cidd/lb/nginx.conf.template ./cidd/lb/dist/nginx.conf
  # ...
  sed -i "s/%WORKER_PROCESSES%/$LB_STATIC_NUM/" ./cidd/lb/dist/nginx.conf

  # [+] load balancer
  STATIC_SERVERS=''
  for i in $(seq 1 $LB_STATIC_NUM)
  do
    STATIC_SERVERS="$STATIC_SERVERS\nserver ${COMPOSE_PROJECT_NAME}_${LB_STATIC_NAME}_$i;"
  done
  sed -i "s/%STATIC_SERVERS%/$STATIC_SERVERS/" ./cidd/lb/dist/nginx.conf

  SERVICE_SERVERS=''
  for i in $(seq 1 $LB_SERVICE_NUM)
  do
    SERVICE_SERVERS="$SERVICE_SERVERS\nserver ${COMPOSE_PROJECT_NAME}_${LB_SERVICE_NAME}_$i;"
  done
  sed -i "s/%SERVICE_SERVERS%/$SERVICE_SERVERS/" ./cidd/lb/dist/nginx.conf
  #[-] load balancer

  # [+] static
  rm -rf ./cidd/static/dist
  cp -r ./static/dist ./cidd/static
  # [-] static

  # [+] service
  pushd service
  export SERVICE_ARTIFACT=$(mvn -q -Dexec.executable="echo" -Dexec.args='${project.artifactId}-${project.version}-jar-with-dependencies.${project.packaging}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec)
  popd
  rm -rf ./cidd/service/dist
  mkdir ./cidd/service/dist
  cp "./service/target/${SERVICE_ARTIFACT}" ./cidd/service/dist
  # [-] service

  docker-compose up $1

else
  echo "'$envFile' not found."
  echo "copy '.env.template' to '$envFile' and update it according to your environment"
fi

