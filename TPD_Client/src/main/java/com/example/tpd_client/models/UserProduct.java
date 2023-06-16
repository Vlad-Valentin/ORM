package com.example.tpd_client.models;

import com.example.tpd_client.interfaces.UserProductInterface;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class UserProduct implements UserProductInterface, Serializable {
    private int userId;
    private int productId;

    public UserProduct() {

    }

    public UserProduct(int userId, int productId) {
        this.userId = userId;
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
