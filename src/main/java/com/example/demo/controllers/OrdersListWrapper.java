package com.example.demo.controllers;

import com.example.demo.models.Order;

import java.util.List;

public class OrdersListWrapper {

    private List<Order> orders;

    public OrdersListWrapper() {
    }

    public OrdersListWrapper(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
