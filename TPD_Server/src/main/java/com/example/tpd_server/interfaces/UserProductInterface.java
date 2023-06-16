package com.example.tpd_server.interfaces;

import javax.ejb.Remote;

@Remote
public interface UserProductInterface {
    int getUserId();

    void setUserId(int userId);

    int getProductId();

    void setProductId(int productId);
}
