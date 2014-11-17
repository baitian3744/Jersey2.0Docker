FROM ubuntu:14.04
RUN apt-get update

RUN apt-get install -y openjdk-7-jre-headless wget
RUN apt-get install -y maven
RUN wget -O /tmp/tomcat8.tar.gz http://archive.apache.org/dist/tomcat/tomcat-8/v8.0.9/bin/apache-tomcat-8.0.9.tar.gz
RUN (cd /opt && tar zxf /tmp/tomcat8.tar.gz)
RUN (mv /opt/apache-tomcat* /opt/tomcat)
ENV JAVA_HOME /usr/lib/jvm/java-1.7.0-openjdk-amd64

EXPOSE 8080
CMD ["/opt/tomcat/bin/catalina.sh", "run"]

RUN ["sh","/usr/bin/mvn","clean","package"]
