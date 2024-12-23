package de.tjjf.Infrastructure.Client.ClientOperations.APIOperations;

import de.tjjf.Infrastructure.api.InputModels.APIEmployeeInput;
import de.tjjf.Infrastructure.api.models.APIEmployee;

import java.io.IOException;
import java.net.URISyntaxException;

public class EmployeeAPIOperation extends AbstractAPIOperation {

    private String transformToQuery(APIEmployeeInput apiEmployeeInput, String commandName) {
        String query = """
        {
            "query": "mutation {
                %s (employee: {
                    employeeID: %d,
                    firstName: \\"%s\\",
                    middleName: \\"%s\\",
                    lastName: \\"%s\\",
                    dateOfBirth: \\"%s\\",
                    address: {
                        street: \\"%s\\",
                        number: %d,
                        zipCode: %d,
                        city: \\"%s\\",
                        country: \\"%s\\"
                    },
                    email: \\"%s\\"
                    airlineName: \\"%s\\",
                })
            }"
        }
        """.formatted(
                commandName,
                apiEmployeeInput.getEmployeeId(),
                apiEmployeeInput.getFirstName(),
                apiEmployeeInput.getMiddleNames(),
                apiEmployeeInput.getLastName(),
                apiEmployeeInput.getDateOfBirthInRFC3339(),
                apiEmployeeInput.getAddress().getStreet(),
                apiEmployeeInput.getAddress().getNumber(),
                apiEmployeeInput.getAddress().getZipcode(),
                apiEmployeeInput.getAddress().getCity(),
                apiEmployeeInput.getAddress().getCountry(),
                apiEmployeeInput.getEmail(),
                apiEmployeeInput.getAirline()
        );

        return query;

    }

        public void createEmployee(APIEmployeeInput apiEmployeeInput) {
            execute(transformToQuery(apiEmployeeInput, "createEmployee"), "createEmployee", APIEmployee.class);
        }

        public void updateEmployee(APIEmployeeInput apiEmployeeInput) {
            execute(transformToQuery(apiEmployeeInput, "updateEmployee"), "updateEmployee", APIEmployee.class);
        }

        public APIEmployee readEmployeeById(int employeeId) throws URISyntaxException, IOException, InterruptedException {
            String query = """
            {
                "query": "{
                    readEmployeeById(employeeId: %d) {
                        employeeID
                        firstName
                        middleName
                        lastName
                        dateOfBirth
                        address {
                            street
                            number
                            zipCode
                            city
                            country
                        }
                        email
                        airlineName
                    }
                }"
            }
            """.formatted(employeeId);
            return execute(query, "readEmployeeById", APIEmployee.class);
        }
}
