package com;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class Request {
    private String apiKey = "ceb1fdf0bba281464974ba83";

    public String getRequestPair(String pairOne, String pairTwo, String amount) throws IOException, InterruptedException {
        String address = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" +
                pairOne + "/" + pairTwo + "/" + amount;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getRequestSingle(String pair) throws IOException, InterruptedException {
        String address = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/"  + pair;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
