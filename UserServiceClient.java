package com.example.orders.client;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Calls the user service in utkarshbito/testing-bito. Every endpoint here is
 * served by UserController in that repository.
 */
@Component
public class UserServiceClient {

    private static final String BASE = "http://testing-bito/api/users";
    private final HttpClient http = HttpClient.newHttpClient();

    /** GET http://testing-bito/api/users/{id} -> UserController.getUserById */
    public String fetchUser(Long id) throws Exception {
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE + "/" + id))
                .GET()
                .build();
        return http.send(req, HttpResponse.BodyHandlers.ofString()).body();
    }

    /** GET http://testing-bito/api/users -> UserController.getAllUsers */
    public String listUsers() throws Exception {
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE))
                .GET()
                .build();
        return http.send(req, HttpResponse.BodyHandlers.ofString()).body();
    }

    /** PUT http://testing-bito/api/users/{id} -> UserController.updateUser */
    public String updateUser(Long id, String payload) throws Exception {
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(BASE + "/" + id))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(payload))
                .build();
        return http.send(req, HttpResponse.BodyHandlers.ofString()).body();
    }
}
