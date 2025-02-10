# Stage 1: Build and Test
FROM maven:3.9.9-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# Copy only the necessary files for dependency resolution
COPY pom.xml .

# Resolve dependencies to leverage Docker layer caching
RUN mvn dependency:go-offline -B

# Copy the rest of the application code
COPY src ./src

EXPOSE 8081

# Build the application and run tests
RUN mvn clean package

# Run the application for a brief test
RUN java -jar target/*.jar & \
    sleep 10 && \
    ps aux | grep "[j]ava" || (echo "Application did not start!" && exit 1)

# Stage 2: Runtime
FROM maven:3.9.9-eclipse-temurin-21

# Set working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

COPY --from=build /app/target/ .

# Expose the application port
EXPOSE 8081

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]