package de.tjjf.Infrastructure.GraphQLClient.APIOperations;

import de.tjjf.Infrastructure.api.InputModels.APIClientInput;
import de.tjjf.Infrastructure.api.models.APIClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class ClientAPIOperation extends AbstractAPIOperation {

    private String transformToQuery(APIClientInput apiClientInput, Long clientId, String commandName, boolean hasResult) {
        String query = """
        {
            "query": "mutation {
                %s ( %s client: {
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
                    email: \\"%s\\",
                    isBusinessClient: %b
                } ) %s
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
                apiClientInput.isBusinessClient(),
                (hasResult) ? "{clientId firstName middleNames lastName dateOfBirth phoneNumber address{ street number zipCode city country} email isBusinessClient}" : ""
        );

        return query;

    }

        public APIClient createClient(APIClientInput apiClientInput) {
            return execute(transformToQuery(apiClientInput, null, "createClient", true), "createClient", APIClient.class);
        }

        public void updateClient(Long clientId, APIClientInput apiClientInput) {
            execute(transformToQuery(apiClientInput, clientId, "updateClient", false), "updateClient", APIClient.class);
        }

        public APIClient readClientById(long clientId) throws URISyntaxException, IOException, InterruptedException {
            String query = """
            {
                "query": "{
                    readClientById(clientId: %d) {
                        clientId
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
                        isBusinessClient
                    }
                }"
            }
            """.formatted(clientId);
            return execute(query, "readClientById", APIClient.class);
        }
}
