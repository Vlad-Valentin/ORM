package com.example.tpd_server.interfaces;

import javax.ejb.Remote;

@Remote
public interface ProductInterface {
    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    int getPrice();

    void setPrice(int price);
}
