FROM openjdk:8u171-jre-alpine

#
ARG SERVICE_API_HOST
ARG SERVICE_API_LSTN
ARG SERVICE_API_PORT
ARG SERVICE_API_PORTS

ENV SERVICE_API_PORT ${SERVICE_API_PORT}
#
RUN apk --update --no-cache add curl

#
HEALTHCHECK --interval=5s --timeout=3s CMD curl --fail http://localhost:${SERVICE_API_PORT}/healthcheck || exit 1
#HEALTHCHECK --interval=5s --timeout=3s CMD curl --fail http://localhost:8080/healthcheck || exit 1

# Create app directory
WORKDIR /usr/app

COPY ./target/*.jar ./
COPY ./docker-entry.sh ./

CMD [ "./docker-entry.sh" ]
