package com.example.tpd_client.interfaces;

import javax.ejb.Local;

@Local
public interface UserProductInterface {
    int getUserId();

    void setUserId(int userId);

    int getProductId();

    void setProductId(int productId);
}
