# Basis-Image mit Java 21 und Maven
FROM maven:3.9.9-eclipse-temurin-21 AS build

# Arbeitsverzeichnis festlegen
WORKDIR /app

# Kopiere die Maven-POM und die Quellcode-Dateien
COPY pom.xml .
COPY src ./src

# Baue das Projekt
RUN mvn clean package

# run stage
FROM maven:3.9.9-eclipse-temurin-21

# set workdir again
WORKDIR /app

# get build image
COPY --from=build /app/target/*.jar app.jar

# Exponiere den benötigten Port
EXPOSE 8081

# Führe den Server aus, wenn der Container gestartet wird
CMD ["java", "-jar", "app.jar"]


