package de.tjjf.Domain.UseCases;


import de.tjjf.Domain.Exceptions.AuthException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AuthenticationUseCase {
    private static AuthenticationUseCase instance;
    public String token;

    private AuthenticationUseCase() {}

    public static AuthenticationUseCase getInstance() {
        if (instance == null) {
            instance = new AuthenticationUseCase();
        }
        return instance;
    }

    private static String serverURL = "https://staging.api.fiw.thws.de/auth/api/users/me";

    public static String authenticate(String username, String password) throws AuthException {
        AuthenticationUseCase authenticationUseCase = getInstance();
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
                authenticationUseCase.token = response.headers().map().get("X-fhws-jwt-token").getFirst(); //extract the token from the response header
                return authenticationUseCase.token;
            } else {
                throw new RuntimeException("Authentication failed, Username or Password are not Valid");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new AuthException("Authentication failed, Username or Password are not Valid", e);
        }
    }

    public boolean isAuthorized() {
        AuthenticationUseCase authenticationUseCase = getInstance();
        if(authenticationUseCase.token == null || authenticationUseCase.token.isEmpty()) return false;
        // check whether token is still valid
        try (final HttpClient httpClient = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(serverURL))
                    .header("Authorization", "Bearer " + token)
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public String getToken() {
        return token;
    }

    public static void main(String[] args) {
        //authenticate("testest", "testtestse");
        AuthenticationUseCase auth = new AuthenticationUseCase();
        auth.token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJrNjUzODkiLCJleHAiOjE3MzQ5NTIyOTl9.IdLVLC42usbm2finQGgNxVpSLnt4cAI59toz1rN066kylTdxQU-7E0YUBjJUqeL72slB5ZZAH85rKSUHCr2NSw";
        System.out.println(auth.isAuthorized());
    }

}
