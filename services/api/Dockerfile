FROM openjdk:8u171-jre-alpine

#
ARG COMPONENT_PARAM_HOST
ARG COMPONENT_PARAM_LSTN
ARG COMPONENT_PARAM_PORT
ARG COMPONENT_PARAM_PORTS

ENV COMPONENT_PARAM_PORT ${COMPONENT_PARAM_PORT}
#
RUN apk --update --no-cache add curl

#
HEALTHCHECK --interval=5s --timeout=3s CMD curl --fail http://localhost:${COMPONENT_PARAM_PORT}/healthcheck || exit 1
#HEALTHCHECK --interval=5s --timeout=3s CMD curl --fail http://localhost:8080/healthcheck || exit 1

# Create app directory
WORKDIR /usr/app

COPY ./target/*.jar ./
COPY ./docker-entry.sh ./

CMD [ "./docker-entry.sh" ]
