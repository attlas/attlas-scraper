FROM openjdk:8u151-jre

ARG DEMON_ARTIFACT
ARG DEMON_HOSTNAME
ARG DEMON_PORT
ARG DEMON_DATA_HOME

ENV DEMON_ARTIFACT $DEMON_ARTIFACT
ENV DEMON_HOSTNAME $DEMON_HOSTNAME
ENV DEMON_PORT $DEMON_PORT
ENV DEMON_DATA_HOME $DEMON_DATA_HOME

RUN apt-get update && apt-get -y install \
  php7.0-fpm \
  php7.0-curl \
  php7.0-mcrypt \
  php7.0-cli \
  php7.0-mbstring \
  mc

COPY ./dist /
CMD exec java -jar /${DEMON_ARTIFACT}
