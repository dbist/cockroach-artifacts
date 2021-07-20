#!/bin/bash

docker compose build --no-cache
docker compose up -d
mkdir -p .postgresql
docker cp $HOME/.postgresql/root.crt app:/code/.postgresql/root.crt
docker logs -f app
