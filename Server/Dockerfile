FROM openjdk:21-jdk-slim

ADD target/Server-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
EXPOSE 9090

ENTRYPOINT ["java","-jar","app.jar"]