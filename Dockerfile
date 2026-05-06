# Use Java 21 base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the project
RUN ./mvnw clean package -DskipTests

# Run the jar
CMD ["java", "-jar", "target/*.jar"]