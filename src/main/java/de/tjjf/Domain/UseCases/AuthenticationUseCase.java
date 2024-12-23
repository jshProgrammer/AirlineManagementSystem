package de.tjjf.Domain.UseCases;


import de.tjjf.Domain.Exceptions.AuthException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AuthenticationUseCase {
    public String token;

    public static void main(String[] args) {
        authenticate("testest", "testtestse");
    }

    private static String serverURL = "https://staging.api.fiw.thws.de/auth/api/users/me";

    public static String authenticate(String username, String password) throws AuthException {
        try (final HttpClient httpClient = HttpClient.newHttpClient()) {
            //TODO: implement test token

            String auth = username + ":" + password;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(serverURL))
                    .header("Authorization", "Basic " + encodedAuth)
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String token = response.headers().map().get("X-fhws-jwt-token").getFirst(); //extract the token from the response header
                return token;
            } else {
                throw new RuntimeException("Authentication failed, Username or Password are not Valid");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new AuthException("Authentication failed, Username or Password are not Valid", e);
        }
    }

    public boolean isAuthorized() {
        return token != null && !token.isEmpty();
    }

    public String getToken() {
        return token;
    }

}
