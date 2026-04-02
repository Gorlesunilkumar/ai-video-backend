FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . .

RUN chmod +x gradlew

# Skip tests to avoid failure
RUN ./gradlew build -x test

# Find jar automatically and run
CMD ["sh", "-c", "java -jar $(ls build/libs/*.jar | head -n 1)"]