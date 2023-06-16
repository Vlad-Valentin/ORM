package com.example.tpd_server.controllers;

import com.example.tpd_server.models.Product;
import com.example.tpd_server.models.UserProduct;
import com.example.tpd_server.services.UserProductService;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/user-products")
public class UserProductController {
    private static final UserProductService userProductService = new UserProductService();

    @GET
    @Produces("application/json")
    public List<UserProduct> getAll() {
        return userProductService.getAll();
    }

    @GET
    @Produces("application/json")
    @Path("/{userId}")
    public List<Product> getProductsForUser(@PathParam("userId") int userId) {
        return userProductService.getProductsForUser(userId);
    }

    @POST
    @Consumes("application/json")
    public void add(String response) {
        userProductService.add(response);
    }

    @DELETE
    @Consumes("application/json")
    @Path("/{userId}/{productId}")
    public void delete(@PathParam("userId") int userId, @PathParam("productId") int productId) {
        userProductService.delete(userId, productId);
    }
}
