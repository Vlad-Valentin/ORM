package com.example.tpd_client.models;

import com.example.tpd_client.interfaces.ProductInterface;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class Product implements ProductInterface, Serializable {
    private int id;
    private String name;

    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
