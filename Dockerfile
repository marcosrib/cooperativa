FROM openjdk:11-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} cooperativa-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/cooperativa-0.0.1-SNAPSHOT.jar"]