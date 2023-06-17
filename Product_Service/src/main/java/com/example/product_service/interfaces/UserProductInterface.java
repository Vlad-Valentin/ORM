package com.example.product_service.interfaces;

import javax.ejb.Remote;

@Remote
public interface UserProductInterface {
    int getUserId();

    void setUserId(int userId);

    int getProductId();

    void setProductId(int productId);
}
