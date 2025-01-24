# AirlineManagementSystem

We developed a comprehensive Airline Management System that efficiently handles flights, ticketing for both customers and employees, and management of airline operations. 
The system supports multiple airlines as subsidiaries, each with its own team of employees, enabling decentralized management while maintaining overall control.
Additionally, it provides well-defined ports for seamless communication with databases and external APIs, facilitating integration and data exchange with other systems. 
For payment validation, the system integrates with Stripe, ensuring secure and efficient processing of transactions. 
Authentication with THWS username and password, as well as token-based authentication, was prepared. However, due to the lack of proper error handling support in the GraphQL client, it was not utilized and commented out.

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

## Project Structure

The basic structure of this Maven project is as follows:
```
AirlineManagementSystem/
|--.idea/
|--src/
|   |--main/
|   |   |--java/
|   |   |   |--de.tjjf/
|   |   |       |--Domain/
|   |   |       |   |--Exceptions/
|   |   |       |   |--models/
|   |   |       |   |--ports/
|   |   |       |   |   |--API/
|   |   |       |   |   |--DB/
|   |   |       |   |--UseCases/
|   |   |       |   |   |--Services/
|   |   |       |--Infrastructure/
|   |   |           |--api/
|   |   |           |   |--adapter/
|   |   |           |   |--APIExtensions/
|   |   |           |   |--InputModels/
|   |   |           |   |--mapper/
|   |   |           |   |--models/
|   |   |           |   |--resolvers/
|   |   |           |   |--services/
|   |   |           |--GraphQL Client/
|   |   |           |   |--APIOperations/
|   |   |           |   |--results/
|   |   |           |--persistence/
|   |   |               |--adapter/
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
|               |   |--APILevel
|               |   |--BusinessLevel
|               |   |--PersistenceLevel
|               |--IntegrationTests/
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

3. Start the server:
   ```bash
   mvn spring-boot:run
   ```
   
4. Execute the test cases in a separate terminal
    ```bash
   mvn verify
   ```

The test results can be found in the folder `target/surefire-reports`.

## Licence

This project is under the [MIT-Lizenz](LICENSE).

## Contributor

- [Jasmin Wander] https://github.com/xjasx4
- [Finn Krappitz] https://github.com/hendrickson187
- [Tom Knoblach] https://github.com/Gottschalk125
- [Joshua Pfennig] https://github.com/jshProgrammer

