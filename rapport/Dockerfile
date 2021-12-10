FROM maven:3.5-jdk-11-slim AS build
COPY target/rapport-0.0.1-SNAPSHOT.jar rapport-service.jar
ENTRYPOINT ["java","-jar","/rapport-service.jar"]
