#!/bin/bash

echo "[+] Building ..."

echo " | [+] Static ..."
echo " | [-] Static"

echo " | [+] Service ..."
pushd services/demon
mvn clean install
popd
echo " | [-] Service"

echo "[-] Building"
