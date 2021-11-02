# Author: Mustang
# 基础镜像使用java,alpines表示最小镜像的Linux系统 docker pull openjdk:11.0.12-jdk-oracle
FROM openjdk:11.0.12-jdk-oracle

#USER root

# 作者
MAINTAINER Mustang Kong <mustang2247@gmail.com>

EXPOSE 9080

VOLUME /tmp
ADD ./target/java-web-base.jar  /app.jar
RUN bash -c 'touch /app.jar'

ENTRYPOINT ["java","-jar","/app.jar"]
