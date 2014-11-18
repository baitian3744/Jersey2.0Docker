FROM ubuntu:14.04
RUN apt-get update

RUN apt-get install -y openjdk-7-jre-headless wget
RUN apt-get install -y maven git
#RUN wget -O /tmp/tomcat8.tar.gz http://archive.apache.org/dist/tomcat/tomcat-8/v8.0.9/bin/apache-tomcat-8.0.9.tar.gz
#RUN (cd /opt && tar zxf /tmp/tomcat8.tar.gz)

RUN wget -O /tmp/tomcat8.tar.gz http://www.gtlib.gatech.edu/pub/apache/tomcat/tomcat-7/v7.0.57/bin/apache-tomcat-7.0.57.tar.gz
RUN (cd /opt && tar zxf /tmp/tomcat8.tar.gz)

RUN (mv /opt/apache-tomcat* /opt/tomcat)
ENV JAVA_HOME /usr/lib/jvm/java-1.7.0-openjdk-amd64


#RUN (git clone https://github.com/hareendran/Jersey2.0Docker.git)
#RUN (cd Jersey2.0Docker &&  git pull origin master && mvn clean package)
RUN  (mkdir Jersey2.0Docker )
COPY . /Jersey2.0Docker
RUN  ( cd /Jersey2.0Docker && mvn clean package)
RUN (cp /Jersey2.0Docker/target/*.war /opt/tomcat/webapps)

EXPOSE 8080
CMD ["/opt/tomcat/bin/catalina.sh","run"]
