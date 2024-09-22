# Use the official Gradle image to build the application
FROM gradle:8.0.2-jdk11 AS build

WORKDIR /app

COPY build.gradle settings.gradle ./
COPY src ./src

RUN gradle build --no-daemon

# Use a minimal JRE base image for the runtime
FROM openjdk:11-jre-slim

WORKDIR /app

# Update this path to match the actual JAR file name
COPY --from=build /app/build/libs/sample-1.0-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]