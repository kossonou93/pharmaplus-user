# Start with base image
FROM openjdk:17-jdk-alpine

# Add Maintainer Info
LABEL maintainer="Docker with microservices"

# Add a temporary volume
VOLUME /tmp

# Expose Port 8080
EXPOSE 8081

# Application Jar File
ARG JAR_FILE=target/pharmaplus-user-0.0.1-SNAPSHOT.jar

# Add Application Jar File to the Container
ADD ${JAR_FILE} pharmaplus-user.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/pharmaplus-user.jar"]