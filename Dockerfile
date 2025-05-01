FROM openjdk:8-jdk-slim

WORKDIR /app

COPY *.java ./LandManagementSystem/

RUN javac LandManagementSystem/*.java

CMD ["java", "LandManagementSystem.Main"]





