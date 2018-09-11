package com.example.demo.quickrepo.jpa;

import com.example.demo.models.Order;
import com.example.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository implements QuickRepository {

    @Autowired
    private OrderJpa orderJpa;

    @Autowired
    private ProductJpa productJpa;

    public Order getOrderById(Long id) {
        return orderJpa.getOne(id);
    }

    public Product getProductById(Long id) {
        return productJpa.getOne(id);
    }
}
