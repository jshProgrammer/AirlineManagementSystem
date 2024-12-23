package de.tjjf.Infrastructure.Client.ClientOperations.APIOperations;

import de.tjjf.Infrastructure.api.InputModels.APIAirportInput;
import de.tjjf.Infrastructure.api.models.APIAirport;

public class AirportAPIOperation extends AbstractAPIOperation {

    private String transformToQuery(APIAirportInput apiAirportInput, String commandName) {
        String query = """
        {
            "query": "mutation {
                %s (airport: {
                    code: \\"%s\\",
                    name: \\"%s\\",
                    country: \\"%s\\",
                    city: \\"%s\\",
                    timezone: \\"%s\\"                  
                })
            }"
        }
        """.formatted(
                commandName,
                apiAirportInput.getCode(),
                apiAirportInput.getName(),
                apiAirportInput.getCountry(),
                apiAirportInput.getCity(),
                apiAirportInput.getTimezone()
        );

        return query;

    }


    public void createAirport(APIAirportInput apiAirportInput) {
        execute(transformToQuery(apiAirportInput, "createAirport"), "createAirport", APIAirportInput.class);
    }

    public APIAirport readAirportByCode(String code) {
        String query = """
        {
            "query": "{
                readAirportByCode(code: \\"%s\\") {
                    code
                    name
                    country
                    city
                    timezone
                }
            }"
        }
        """.formatted(code);

        return execute(query, "readAirportByCode", APIAirport.class);
    }
}
