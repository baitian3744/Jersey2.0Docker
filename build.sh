#!/bin/sh
docker build -t tomcat7/jersey .
docker run -p 8080:8080 -d tomcat7/jersey
