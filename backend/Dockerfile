# Use the official Maven image to build the project
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use the official OpenJDK image to run the app
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/image_gallery-0.0.1.jar
COPY ${JAR_FILE} image_gallery.jar
ENTRYPOINT ["java", "-jar", "image_gallery.jar"]

# Expose the application port
EXPOSE 8081

