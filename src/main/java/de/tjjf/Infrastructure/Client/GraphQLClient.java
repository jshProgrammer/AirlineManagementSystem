package de.tjjf.Infrastructure.Client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.tjjf.Infrastructure.Client.ClientOperations.ImplOperations.AirlineAPIOperation;
import de.tjjf.Infrastructure.Client.ClientOperations.ImplOperations.AirplaneAPIOperation;
import de.tjjf.Infrastructure.Client.ClientOperations.ImplOperations.FlightAPIOperation;
import de.tjjf.Infrastructure.api.InputModels.APIAddressInput;
import de.tjjf.Infrastructure.api.InputModels.APIAirlineInput;
import de.tjjf.Infrastructure.api.InputModels.APIAirplaneInput;
import de.tjjf.Infrastructure.api.InputModels.APIFlightInput;
import de.tjjf.Infrastructure.api.models.APIAirline;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GraphQLClient {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        GraphQLClient client = new GraphQLClient();
        //new AirlineAPIOperation().readAirlineByName("Test ");

        //new FlightAPIOperation().createFlight(new APIFlightInput(1, 1, new Date(2000, 01,01), "Test", new Date(2000, 01,01), "Test", new Date(2000, 01,01), ))

        //new AirlineAPIOperation().createAirline(new APIAirlineInput("Test", new Date(2005, 01, 01), new APIAddressInput("Test", 1, 91237, "Berlin", "Germany" ), "+49234o1u324", "test@test.de"  ));
        //new AirplaneAPIOperation().createAirplane(new APIAirplaneInput(123, "MeineAirline", true));
        //new AirplaneAPIOperation().readAirplaneBySerialNum(123);
    }

    public APIAirline readAirlineByName(String name) throws URISyntaxException, IOException, InterruptedException {
        try(HttpClient client = HttpClient.newHttpClient();) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/airlineManagement"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{ \"query\": \"mutation { readAirlineByName(name: \\\"" + name + "\\\") { " + "name foundationYear phoneNumber email" + " } }\" }"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();
            System.out.println("Response Body: " + responseBody);

            ObjectMapper objectMapper = new ObjectMapper();
            var result = objectMapper.readValue(responseBody,
                    new TypeReference<Map>() {
                    }
            );
            if (result.containsKey("errors")) {
                List<Map<String, Object>> errors = (List<Map<String, Object>>) result.get("errors");
                for (Map<String, Object> error : errors) {
                    String message = (String) error.get("message");
                    System.err.println("GraphQL Error: " + message);
                }
                throw new RuntimeException("GraphQL request failed with errors.");
            }

            Map<String, Object> dataMap = (Map<String, Object>) result.get("data");
            Map<String, Object> modelsList = (Map<String, Object>) dataMap.get("readAirlineByName");

            return objectMapper.convertValue(modelsList, APIAirline.class);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}