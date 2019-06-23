package com.example.demo.model;

import java.io.Serializable;

public class Good implements Serializable {
    private Integer id;
    private String name;
    private Integer stock;
    private Integer price;
    private String category;
    private String description;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Good(int id, String name, int stock, int price, String category, String description, String username) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.category = category;
        this.description = description;
        this.username = username;
    }
}
