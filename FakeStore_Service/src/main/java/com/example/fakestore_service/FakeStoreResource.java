package com.example.fakestore_service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/fake-store")
public class FakeStoreResource {
    private static final String API_URL = "https://fakestoreapi.com/products";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProducts() {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URL)
                .request(MediaType.APPLICATION_JSON)
                .get();

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            return response.readEntity(String.class);
        } else {
            return "Error sending GET request. Response code: " + response.getStatus();
        }
    }
}