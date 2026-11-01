
# Stage 1: Build the Java application
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copy Maven configuration
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy application source code
COPY src ./src

# Compile, test and package
RUN mvn clean package

# Stage 2: Create lightweight runtime image
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the generated JAR
COPY --from=build /app/target/devops-app-1.0.0.jar app.jar

# Application port
EXPOSE 8082

# Start application
ENTRYPOINT ["java", "-jar", "app.jar"]
