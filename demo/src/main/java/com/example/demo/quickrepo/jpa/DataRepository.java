package com.example.demo.quickrepo.jpa;

import com.example.demo.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository implements QuickRepository {

    @Autowired
    OrderJpa orderJpa;

    public Order getOrderById(Long id) {
        return orderJpa.getOne(id);
    }
}
