#!/bin/bash

export DEMON_DATA_HOME=/opt/attlas
export TOR_HOST=127.0.0.1
export TOR_SOCKS_PORT=9050

mvn clean install exec:java