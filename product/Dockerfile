# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container
COPY target/*.jar app.jar
ADD target/eureka-server.jar eureka-server.jar
# Expose the port on which the service will run
EXPOSE 8088

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
