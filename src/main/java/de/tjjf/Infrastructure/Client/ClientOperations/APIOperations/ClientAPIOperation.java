package de.tjjf.Infrastructure.Client.ClientOperations.APIOperations;

import de.tjjf.Infrastructure.api.InputModels.APIClientInput;
import de.tjjf.Infrastructure.api.models.APIClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class ClientAPIOperation extends AbstractAPIOperation {

    private String transformToQuery(APIClientInput apiClientInput, Long clientId, String commandName) {
        String query = """
        {
            "query": "mutation {
                %s ( %s client: {
                    clientID: %d,
                    firstName: \\"%s\\",
                    middleName: \\"%s\\",
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
                    isBusinessClient: \\"%b\\",
                })
            }"
        }
        """.formatted(
                commandName,
                (clientId == null) ? "" : "clientId: %d,".formatted(clientId),
                apiClientInput.getFirstName(),
                apiClientInput.getMiddleNames(),
                apiClientInput.getLastName(),
                apiClientInput.getDateOfBirthInRFC3339(),
                apiClientInput.getPhoneNumber(),
                apiClientInput.getAddress().getStreet(),
                apiClientInput.getAddress().getNumber(),
                apiClientInput.getAddress().getZipCode(),
                apiClientInput.getAddress().getCity(),
                apiClientInput.getAddress().getCountry(),
                apiClientInput.getEmail(),
                apiClientInput.isBusinessClient()
        );

        return query;

    }

        public void createClient(APIClientInput apiClientInput) {
            execute(transformToQuery(apiClientInput, null, "createClient"), "createClient", APIClient.class);
        }

        public void updateClient(Long clientId, APIClientInput apiClientInput) {
            execute(transformToQuery(apiClientInput, clientId, "updateClient"), "updateClient", APIClient.class);
        }

        public APIClient readClientById(int clientId) throws URISyntaxException, IOException, InterruptedException {
            String query = """
            {
                "query": "{
                    readClientById(clientId: %d) {
                        clientId
                        firstName
                        middleName
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
                        isBusinessClient
                    }
                }"
            }
            """.formatted(clientId);
            return execute(query, "readClientById", APIClient.class);
        }
}
