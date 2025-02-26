# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim as builder

# Set the working directory in the container
WORKDIR /app

# Copy the local code to the container
COPY . /app

# Install Maven and build the application
RUN apt-get update && apt-get install -y maven
RUN mvn clean install -DskipTests

# Run the Spring Boot app
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=builder /app/target/HospitalManagementApplication-0.0.1-SNAPSHOT.jar /app/HospitalManagementApplication.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "HospitalManagementApplication.jar"]
