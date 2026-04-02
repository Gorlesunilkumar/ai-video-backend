# Use Java 17
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Give permission
RUN chmod +x gradlew

# Build project
RUN ./gradlew build

# Run jar
CMD ["java", "-jar", "build/libs/*.jar"]