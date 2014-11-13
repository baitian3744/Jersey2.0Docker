#!/bin/sh
docker build -t hari/jersey .
docker run -p 8080:8080 -d hari/jersey
