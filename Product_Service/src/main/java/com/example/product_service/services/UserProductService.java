package com.example.product_service.services;

import com.example.product_service.dal.UserProductDAO;
import com.example.product_service.models.Product;
import com.example.product_service.models.UserProduct;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class UserProductService {
    public ArrayList<UserProduct> getAll() {
        return UserProductDAO.getAll();
    }

    public List<Product> getProductsForUser(int userId) {
        if (userId < 0) {
            return null;
        }
        return UserProductDAO.getProductsForUser(userId);
    }

    public void add(String response) {
        if (response.isEmpty()) {
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            UserProduct userProduct = mapper.readValue(response, new TypeReference<>() {
            });
            UserProductDAO.add(userProduct);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int userId, int productId) {
        if (userId < 0 || productId < 0) {
            return;
        }

        try {
            UserProductDAO.delete(userId, productId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
