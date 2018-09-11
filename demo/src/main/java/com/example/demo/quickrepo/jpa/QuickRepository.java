package com.example.demo.quickrepo.jpa;


import com.example.demo.models.Order;

public interface QuickRepository {

    Order getOrderById(Long id);

}
