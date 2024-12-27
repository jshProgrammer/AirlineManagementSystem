package de.tjjf.Infrastructure.Client.ClientOperations.APIOperations;

import de.tjjf.Infrastructure.api.InputModels.APIEmployeeInput;
import de.tjjf.Infrastructure.api.models.APIEmployee;

import java.io.IOException;
import java.net.URISyntaxException;

public class EmployeeAPIOperation extends AbstractAPIOperation {

    private String transformToQuery(APIEmployeeInput apiEmployeeInput, Long employeeId, String commandName) {
        String query = """
        {
            "query": "mutation {
                %s ( %s employee: {
                    firstName: \\"%s\\",
                    middleNames: \\"%s\\",
                    lastName: \\"%s\\",
                    dateOfBirth: \\"%s\\",
                    phoneNumber: \\"%s\\",
                    address: {
                        street: \\"%s\\",
                        number: %d,
                        zipCode: %d,
                        city: \\"%s\\",
                        country: \\"%s\\"
                    },
                    email: \\"%s\\"
                    airlineName: \\"%s\\",
                }) {
                    employeeId
                    firstName
                    middleNames
                    lastName
                    dateOfBirth
                    phoneNumber
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
        """.formatted(
                commandName,
                (employeeId == 0L) ? "" : "employeeId: %d,".formatted(employeeId),
                apiEmployeeInput.getFirstName(),
                apiEmployeeInput.getMiddleNames(),
                apiEmployeeInput.getLastName(),
                apiEmployeeInput.getDateOfBirthInRFC3339(),
                apiEmployeeInput.getPhoneNumber(),
                apiEmployeeInput.getAddress().getStreet(),
                apiEmployeeInput.getAddress().getNumber(),
                apiEmployeeInput.getAddress().getZipCode(),
                apiEmployeeInput.getAddress().getCity(),
                apiEmployeeInput.getAddress().getCountry(),
                apiEmployeeInput.getEmail(),
                apiEmployeeInput.getAirline()
        );

        return query;

    }

        public APIEmployee createEmployee(APIEmployeeInput apiEmployeeInput) {
            return execute(transformToQuery(apiEmployeeInput, 0L, "createEmployee"), "createEmployee", APIEmployee.class);
        }

        public void updateEmployee(Long employeeId, APIEmployeeInput apiEmployeeInput) {
            execute(transformToQuery(apiEmployeeInput,  employeeId, "updateEmployee"), "updateEmployee", APIEmployee.class);
        }

        public APIEmployee readEmployeeById(int employeeId) throws URISyntaxException, IOException, InterruptedException {
            String query = """
            {
                "query": "{
                    readEmployeeById(employeeId: %d) {
                        employeeId
                        firstName
                        middleNames
                        lastName
                        dateOfBirth
                        phoneNumber
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
