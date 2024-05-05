FROM openjdk:21-jdk-slim

ADD target/Server-0.0.1-SNAPSHOT.jar app.jar

ENV DB_HOST=beautysaloon_db
ENV DB_PORT=3306
ENV DB_NAME=beautysaloon
ENV DB_USERNAME=root
ENV DB_PASSWORD=1234

EXPOSE 8080
EXPOSE 9090

ENTRYPOINT ["java","-jar","app.jar"]