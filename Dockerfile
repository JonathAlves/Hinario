FROM maven:3.9.7-openjdk-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
FROM openjdk:21-jdk-slim
RUN mkdir /app
WORKDIR /app
COPY target/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]


