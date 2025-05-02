FROM openjdk:8-jdk-slim

WORKDIR /app

COPY *.java ./MissionManagementSystem/

RUN javac MissionManagementSystem/*.java

CMD ["java", "MissionManagementSystem.Main"]
