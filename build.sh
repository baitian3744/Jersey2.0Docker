#!/bin/sh
docker build -t hari .
docker run -p 8080:8080 -d hari
