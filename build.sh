#!/bin/bash

echo "[+] Building ..."

echo " | [+] Static ..."
echo " | [-] Static"

echo " | [+] Service ..."
pushd services/scrapper
mvn clean install
popd
echo " | [-] Service"

echo "[-] Building"
