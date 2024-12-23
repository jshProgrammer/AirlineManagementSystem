package de.tjjf.Infrastructure.Client.ClientOperations.APIOperations;

import de.tjjf.Infrastructure.api.InputModels.APIAirlineInput;
import de.tjjf.Infrastructure.api.models.APIAirline;

import java.io.IOException;
import java.net.URISyntaxException;

public class AirlineAPIOperation extends AbstractAPIOperation {

    //TODO: extract address query for DRY-reasons
    private String transformToQuery(APIAirlineInput apiAirlineInput, String commandName) {
        String query = """
        {
            "query": "mutation {
                %s (airline: {
                    name: \\"%s\\",
                    foundationYear: \\"%s\\",
                    address: {
                        street: \\"%s\\",
                        number: %d,
                        zipCode: %d,
                        city: \\"%s\\",
                        country: \\"%s\\"
                    },
                    phoneNumber: \\"%s\\",
                    email: \\"%s\\"
                })
            }"
        }
        """.formatted(
                commandName,
                apiAirlineInput.getName(),
                apiAirlineInput.getFoundationYearInRFC3339(),
                apiAirlineInput.getAddress().getStreet(),
                apiAirlineInput.getAddress().getNumber(),
                apiAirlineInput.getAddress().getZipcode(),
                apiAirlineInput.getAddress().getCity(),
                apiAirlineInput.getAddress().getCountry(),
                apiAirlineInput.getPhoneNumber(),
                apiAirlineInput.getEmail()
        );

        return query;

    }


    public void createAirline(APIAirlineInput airlineInput) {
        execute(transformToQuery(airlineInput, "createAirline"), "createAirline",APIAirline.class);
    }

    public void updateAirline(APIAirlineInput airlineInput) {
        execute(transformToQuery(airlineInput, "updateAirline"), "updateAirline", APIAirline.class);
    }

    public APIAirline readAirlineByName(String name) throws URISyntaxException, IOException, InterruptedException {

        String query = """
                {
                    "query": "{
                        readAirlineByName(name: \\"%s\\") {
                            name
                            foundationYear
                            phoneNumber
                            email
                        }
                    }"
                }
                """.formatted(name);
        return execute(query, "readAirlineByName", APIAirline.class);
    }
}
