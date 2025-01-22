# Basis-Image mit Java 21 und Maven
FROM eclipse-temurin:21-jdk AS build

# Installiere Maven
RUN apt-get update && apt-get install -y maven

# Arbeitsverzeichnis festlegen
WORKDIR /app

# Kopiere die Maven-POM und die Quellcode-Dateien
COPY pom.xml .
COPY src ./src

# Baue das Projekt
RUN mvn clean install

# Exponiere den benötigten Port
EXPOSE 8081

# Führe den Server aus, wenn der Container gestartet wird
CMD ["mvn", "spring-boot:run", "verify"]

