#!/bin/bash

echo "[+] Building ..."

echo " | [+] Service ..."
pushd services/demon
mvn clean install
popd
echo " | [-] Service"

echo "[-] Building"
