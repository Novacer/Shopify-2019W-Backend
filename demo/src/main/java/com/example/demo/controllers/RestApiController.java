package com.example.demo.controllers;

import com.example.demo.models.LineItem;
import com.example.demo.models.Order;
import com.example.demo.quickrepo.jpa.DataRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestApiController {

    private final DataRepository dataRepository;

    public RestApiController(DataRepository quickDataRepository) {
        this.dataRepository = quickDataRepository;
    }


    @GetMapping("/api/shop/{shopId}/order/{orderId}")
    public Order getOrder(@PathVariable Long orderId) {

        Order order = this.dataRepository.getOrderById(orderId);

        List<LineItem> items = order.getLineItems();

        double price = 0;

        for (LineItem item : items) {
            price += item.getPrice();
        }

        order.setTotalValue(price);

        return order;
    }
}
