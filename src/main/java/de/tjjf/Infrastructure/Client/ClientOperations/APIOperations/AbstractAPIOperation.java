package de.tjjf.Infrastructure.Client.ClientOperations.APIOperations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public abstract class AbstractAPIOperation {

    private static final String BASE_URL = "http://localhost:8081/airlineManagement";
    private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    private static <R> R sendRequest(String query, String nameOfCommand, TypeReference<R> typeReference) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(query))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        System.out.println("Response Body: " + responseBody);

        Map<String, Object> result = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {});
        if (result.containsKey("errors")) {
            List<Map<String, Object>> errors = (List<Map<String, Object>>) result.get("errors");
            for (Map<String, Object> error : errors) {
                String message = (String) error.get("message");
                System.err.println("GraphQL Error: " + message);
            }
        }

        Map<String, Object> dataMap = (Map<String, Object>) result.get("data");
        Object modelsList = dataMap.get(nameOfCommand);
        return objectMapper.convertValue(modelsList, typeReference);
    }

    private static <R> R sendRequest(String query, String nameOfCommand, Class<R> classOfR) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(query))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        System.out.println("Response Body: " + responseBody);

        Map<String, Object> result = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {});
        if (result.containsKey("errors")) {
            List<Map<String, Object>> errors = (List<Map<String, Object>>) result.get("errors");
            for (Map<String, Object> error : errors) {
                String message = (String) error.get("message");
                System.err.println("GraphQL Error: " + message);
            }
        }

        Map<String, Object> dataMap = (Map<String, Object>) result.get("data");
        Object modelsList = dataMap.get(nameOfCommand);
        return objectMapper.convertValue(modelsList, classOfR);
    }

    public static <R> R execute(String query, String nameOfCommand, Class<R> classOfR) {
        try {
            return sendRequest(query, nameOfCommand, classOfR);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static <R> R execute(String query, String nameOfCommand, TypeReference<R> typeReference) {
        try {
            return sendRequest(query, nameOfCommand, typeReference);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
