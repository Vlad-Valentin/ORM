package com.example.tpd_server.controllers;

import com.example.tpd_server.models.Product;
import com.example.tpd_server.services.ProductService;
import jakarta.ws.rs.*;

import java.util.ArrayList;

@Path("/products")
public class ProductController {
    private static final ProductService productService = new ProductService();

    @GET
    @Produces("application/json")
    public ArrayList<Product> getAll() {
        return productService.getAll();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Product get(@PathParam("id") int id) {
        return productService.get(id);
    }

    @POST
    @Consumes("application/json")
    public void add(String response) {
        productService.add(response);
    }

    @DELETE
    @Consumes("application/json")
    @Path("/{productId}")
    public void delete(@PathParam("productId") int productId) {
        productService.delete(productId);
    }
}
