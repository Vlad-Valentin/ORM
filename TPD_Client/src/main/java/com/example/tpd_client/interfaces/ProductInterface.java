package com.example.tpd_client.interfaces;

import javax.ejb.Local;

@Local
public interface ProductInterface {
    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    int getPrice();

    void setPrice(int price);
}
