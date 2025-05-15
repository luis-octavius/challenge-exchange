package com;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.logging.Logger;

public class Request {
    private String apiKey = Dotenv.load().get("EXCHANGE_API_KEY");
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Logger logger = Logger.getLogger(Request.class.getName());

    public String getRequestPair(String pairOne, String pairTwo, String amount) throws IOException, InterruptedException {
        String address = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" +
                pairOne + "/" + pairTwo + "/" + amount;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getRequestSingle(String pair) throws IOException, InterruptedException {
        String address = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/"  + pair;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
