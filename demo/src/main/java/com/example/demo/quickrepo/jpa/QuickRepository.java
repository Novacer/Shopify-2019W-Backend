package com.example.demo.quickrepo.jpa;


import com.example.demo.models.Order;
import com.example.demo.models.Product;
import com.example.demo.models.Shop;

public interface QuickRepository {

    Order getOrderById(Long id);

    Product getProductById(Long id);

    Shop getShopById(Long id);

}
