FROM amazoncorretto:11-alpine-jdk
MAINTAINER lucas-vidal
COPY target/lucas-vidal-0.0.1-SNAPSHOT.jar  lucas-vidal-app.jar
ENTRYPOINT ["java","-jar","/lucas-vidal-app.jar"]