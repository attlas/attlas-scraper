FROM openjdk:8u171-jre-alpine

ARG COMPONENT_PARAM_HOST
ARG COMPONENT_PARAM_LSTN
ARG COMPONENT_PARAM_PORT
ARG COMPONENT_PARAM_PORTS
ARG COMPONENT_PARAM_ARTIFACT

ENV COMPONENT_PARAM_ARTIFACT ${COMPONENT_PARAM_ARTIFACT}

RUN apk --update --no-cache add curl

HEALTHCHECK --interval=5s --timeout=3s CMD curl --fail http://localhost:${COMPONENT_PARAM_PORT}/healthcheck || exit 1

# Create app directory
WORKDIR /usr/app

COPY ./target/${COMPONENT_PARAM_ARTIFACT} ./

CMD exec java -Djava.security.egd=file:/dev/./urandom -jar ./${COMPONENT_PARAM_ARTIFACT}
