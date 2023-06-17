package com.example.tpd_server.services;

import com.example.tpd_server.dal.ProductDAO;
import com.example.tpd_server.models.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class ProductService {
    public ArrayList<Product> getAll() {
        return ProductDAO.getAll();
    }

    public Product get(int id) {
        if (id < 0) {
            return null;
        }
        return ProductDAO.get(id);
    }

    public void add(String response) {
        if (response.isEmpty()) {
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            Product product = mapper.readValue(response, new TypeReference<>() {
            });
            ProductDAO.add(product);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int productId) {
        if (productId < 0) {
            return;
        }

        try {
            ProductDAO.delete(productId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
