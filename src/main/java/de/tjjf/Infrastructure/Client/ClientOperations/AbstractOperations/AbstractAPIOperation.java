package de.tjjf.Infrastructure.Client.ClientOperations.AbstractOperations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.tjjf.Infrastructure.Client.ClientOperations.results.AbstractResult;
import de.tjjf.Infrastructure.api.models.APIAirline;
import de.tjjf.Infrastructure.api.models.APIModel;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public abstract class AbstractAPIOperation {

    public static <R> R execute(String query, String nameOfCommand, Class<R> classOfR) {
        try(HttpClient client = HttpClient.newHttpClient();) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/airlineManagement"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(query))
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
            Map<String, Object> modelsList = (Map<String, Object>) dataMap.get(nameOfCommand);

            //TODO: hier noch Abfrage ob null falls void

            return objectMapper.convertValue(modelsList, classOfR);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
