# AirlineManagementSystem

Project for the lecture Backend Systems. We devolped the backend for an Airline Management System.

## Conditions

Make sure the following software is installed on your system:


- **Java**: version 21 or higher
    - [installation for Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Maven**: version 4.0 or higher
    - [installation for Maven](https://maven.apache.org/install.html)

Check the installed versions:
```bash
java -version
mvn -version
```

## Projekt Structur

The basic structure of this Maven project is as follows:
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

- **src/main/java/de.tjjf**: Contains the application code
- **src/main/resources**: Contains GraphQl schema and logo for mails
- **src/test/de.tjjf/java**: Contains unit and integration tests
- **pom.xml**: Maven project file

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/jshProgrammer/AirlineManagementSystem.git
   cd AirlineManagementSystem
   ```

2. Install the dependencies and build the project:
   ```bash
   mvn clean install
   ```

3. Start the application (if applicable):
   ```bash
   mvn exec:java -Dexec.mainClass="com.beispiel.Main"
   ```

## Configuration
Hier noch anpassen Wegen Docker 

All configurable settings can be found in the file `src/main/resources/application.properties`

## Tests

Execute the tests with the following command:
```bash
mvn test
```

The test results can be found in the folder `target/surefire-reports`.

## Licence

This project is under the [MIT-Lizenz](LICENSE).

## Contributor

- Jasmin Wander
- Finn Krappitz
- Joshua Pfennig
- Tom Knoblach

