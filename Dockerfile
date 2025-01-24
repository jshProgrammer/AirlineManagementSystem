# Basis-Image mit Java 21 und Maven
FROM maven:3.9.9-eclipse-temurin-21 AS build

# Arbeitsverzeichnis festlegen
WORKDIR /app

# Kopiere die Maven-POM und die Quellcode-Dateien
COPY ../Downloads/fix/pom.xml .
COPY src ./src

# Baue das Projekt
RUN mvn clean package

# Exponiere den benötigten Port
EXPOSE 8081

# Führe den Server aus, wenn der Container gestartet wird
RUN mvn spring-boot:run


