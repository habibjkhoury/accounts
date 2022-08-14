FROM openjdk:8-jdk-alpine
COPY target/transfer-0.0.1-SNAPSHOT.jar transfer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/transfer-0.0.1-SNAPSHOT.jar"]