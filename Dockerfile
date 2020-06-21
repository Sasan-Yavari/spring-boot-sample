FROM openjdk:8-jdk-alpine
MAINTAINER s.yavari@gmail.com
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} weather.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","/weather.jar"]
EXPOSE 8080
