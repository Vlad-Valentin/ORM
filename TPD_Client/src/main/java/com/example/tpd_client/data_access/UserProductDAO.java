package com.example.tpd_client.data_access;

import com.example.tpd_client.models.Product;
import com.example.tpd_client.models.UserProduct;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class UserProductDAO {
    private final static HttpClient client = HttpClient.newHttpClient();

    public static ArrayList<UserProduct> getAllUserProducts() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://34.116.178.195:8080/product-service/api/user-products"))
                .header("Accept", "application/json")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.body().isEmpty()) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<ArrayList<UserProduct>>() {
        });
    }

    public static List<Product> getProductsForUser(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://34.116.178.195:8080/product-service/api/user-products/" + userId))
                .header("Accept", "application/json")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.body().isEmpty()) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<List<Product>>() {
        });
    }


    public static void add(UserProduct userProduct) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(userProduct);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://34.116.178.195:8080/product-service/api/user-products"))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Accept", "application/json")
                .build();
        client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static void delete(int userId, int productId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://34.116.178.195:8080/product-service/api/user-products/" +
                        userId + "/" + productId))
                .DELETE()
                .header("Accept", "application/json")
                .build();
        client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
