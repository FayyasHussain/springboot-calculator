# Use an official OpenJDK image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . .

# Build the application
RUN ./mvnw clean install

# Expose port (optional - Render injects PORT env)
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "target/springboot-calculator-0.0.1-SNAPSHOT.jar"]
