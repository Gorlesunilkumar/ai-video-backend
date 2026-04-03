FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew build -x test --no-daemon

CMD ["sh", "-c", "java -jar $(ls build/libs/*.jar | head -n 1)"]