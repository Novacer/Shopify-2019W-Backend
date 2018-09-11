package com.example.demo.quickrepo.jpa;


import com.example.demo.models.Order;
import com.example.demo.models.Product;

public interface QuickRepository {

    Order getOrderById(Long id);

    Product getProductById(Long id);

}
