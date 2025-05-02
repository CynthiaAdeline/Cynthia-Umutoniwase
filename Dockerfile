<<<<<<< HEAD
# Use the correct base image tag
FROM openjdk:8-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy all .java files into the container (adjust folder name as needed)
COPY *.java ./NurseryManagementSystem/

# Compile all Java source files
RUN javac NurseryManagementSystem/*.java

# Run the main class
CMD ["java", "NurseryManagementSystem.Main"]
=======
FROM openjdk:8-jdk-slim

WORKDIR /app

COPY *.java ./LandManagementSystem/

RUN javac LandManagementSystem/*.java

CMD ["java", "LandManagementSystem.Main"]





>>>>>>> fed3f0d7a4a37f71f0f0cca27451f468f0513a79
