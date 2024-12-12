# AirlineManagementSystem

Projekt für die Vorlesung Backend Systems. Implementierung eines AirlineManagemt Systems

## Voraussetzungen

Stellen Sie sicher, dass folgende Software auf Ihrem System installiert ist:

- **Java**: Version 21 oder höher
    - [Installation von Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Maven**: Version 4.0 oder höher
    - [Installation von Maven](https://maven.apache.org/install.html)

Prüfen Sie die installierten Versionen:
```bash
java -version
mvn -version
```

## Projektstruktur

Die grundlegende Struktur dieses Maven-Projekts sieht folgendermaßen aus:
```
AirlineManagementSystem/
|--.idea/
|--src/
|   |--main/
|   |   |--java/
|   |   |   |--de.tjjf/
|   |   |       |--Adapter/
|   |   |       |   |--APIAdapter/
|   |   |       |   |--DatabaseAdapter/
|   |   |       |--APIExtensions/
|   |   |       |--Domain/
|   |   |       |   |--Exceptions/
|   |   |       |   |--models/
|   |   |       |   |--ports/
|   |   |       |   |   |--API/
|   |   |       |   |   |--DB/
|   |   |       |   |--UseCases/
|   |   |       |--Infrastructure/
|   |   |           |--api/
|   |   |           |   |--APIExtensions/
|   |   |           |   |--InputModels/
|   |   |           |   |--mapper/
|   |   |           |   |--models/
|   |   |           |   |--resolvers/
|   |   |           |--persistence/
|   |   |               |--DBOperations/
|   |   |               |   |--AbstractOperations/
|   |   |               |   |--ImplOperations/
|   |   |               |       |--Create/
|   |   |               |       |--Delete/
|   |   |               |       |--Read/
|   |   |               |       |--Update/
|   |   |               |--entites/
|   |   |               |--mapper/
|   |   |               |--results/
|   |   |--resources/
|   |       |--META-INF/
|   |--test/
|       |--java/
|           |--de.tjjf
|               |--CRUDTests/
|               |   |--BusinessLevel
|               |   |--PersistenceLevel
|               |--LogicTests/
|--pom.xml
|--README.md
```

- **src/main/java/de.tjjf**: Enthält den Anwendungscode
- **src/main/resources**: Enthält GraphQl Schema sowie Logo für Mails
- **src/test/de.tjjf/java**: Enthält Unit- und Integrationstests
- **pom.xml**: Maven-Projektdatei

## Installation

1. Klonen Sie das Repository:
   ```bash
   git clone https://github.com/jshProgrammer/AirlineManagementSystem.git
   cd AirlineManagementSystem
   ```

2. Installieren Sie die Abhängigkeiten und bauen Sie das Projekt:
   ```bash
   mvn clean install
   ```

3. Starten Sie die Anwendung (falls zutreffend):
   ```bash
   mvn exec:java -Dexec.mainClass="com.beispiel.Main"
   ```

## Konfiguration

Alle konfigurierbaren Einstellungen finden Sie in der Datei `src/main/resources/application.properties`. Passen Sie diese Datei nach Bedarf an.

## Tests

Führen Sie die Tests mit folgendem Befehl aus:
```bash
mvn test
```

Die Testergebnisse finden Sie im Ordner `target/surefire-reports`.

## Lizenz

Dieses Projekt steht unter der [MIT-Lizenz](LICENSE).

## Entwickler

- Jasmin Wander
- Finn Krappitz
- Joshua Pfennig
- Tom Knoblach

