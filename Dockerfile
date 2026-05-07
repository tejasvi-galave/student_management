# Use Java 21 image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy all project files
COPY . .

# Give execute permission to mvnw
RUN chmod +x mvnw

# Build project
RUN ./mvnw clean package -DskipTests

# Expose application port
EXPOSE 8080

# Run jar file
CMD java -jar target/*.jar