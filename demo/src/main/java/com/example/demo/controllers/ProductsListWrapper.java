package com.example.demo.controllers;

import com.example.demo.models.Product;

import java.util.List;

public class ProductsListWrapper {

    private List<Product> products;

    public ProductsListWrapper() {
    }

    public ProductsListWrapper(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
