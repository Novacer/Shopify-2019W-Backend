package com.example.demo.controllers;

import com.example.demo.models.LineItem;
import com.example.demo.models.Order;
import com.example.demo.models.Product;
import com.example.demo.models.Shop;
import com.example.demo.quickrepo.jpa.DataRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class RestApiController {

    private final DataRepository dataRepository;

    public RestApiController(DataRepository quickDataRepository) {
        this.dataRepository = quickDataRepository;
    }

    @GetMapping("/api/shop/{shopId}")
    public Shop getShop(@PathVariable Long shopId) {

        Shop shop = dataRepository.getShopById(shopId);

        computeAndSetTotalValue(shop.getOrders());
        mapLineItemValueToProduct(shop.getProducts());

        return shop;
    }

    @GetMapping("/api/shop/{shopId}/product")
    public ProductsListWrapper getAllProducts(@PathVariable Long shopId) {

        Shop shop = dataRepository.getShopById(shopId);

        List<Product> products = shop.getProducts();

        mapLineItemValueToProduct(products);

        return new ProductsListWrapper(products);
    }

    @GetMapping("/api/shop/{shopId}/order")
    public OrdersListWrapper getAllOrders(@PathVariable Long shopId) {

        Shop shop = dataRepository.getShopById(shopId);

        List<Order> orders = shop.getOrders();

        computeAndSetTotalValue(orders);

        return new OrdersListWrapper(orders);
    }


    @GetMapping("/api/shop/{shopId}/order/{orderId}")
    public Order getOrder(@PathVariable Long orderId, @PathVariable Long shopId) throws EntityNotFoundException{

        Order order = this.dataRepository.getOrderById(orderId);

        Long orderShopId = order.getShopId();

        if (shopId.equals(orderShopId)) {

            computeAndSetTotalValue(order);

            return order;
        }

        else {
            throw new EntityNotFoundException("This shop Id does not have this order Id");
        }
    }

    @GetMapping("/api/shop/{shopId}/product/{productId}")
    public Product getProduct(@PathVariable Long productId, @PathVariable Long shopId) throws EntityNotFoundException {

        Product product = this.dataRepository.getProductById(productId);

        Long productShopId = product.getShopId();

        if (shopId.equals(productShopId)) {
            mapLineItemValueToProduct(product);
            return product;
        }

        else {
            throw new EntityNotFoundException("This shop Id does not have this product Id");
        }

    }

    private void computeAndSetTotalValue(Order order) {

        List<LineItem> items = order.getLineItems();

        double price = 0;

        for (LineItem item : items) {
            price += item.getPrice();
        }

        order.setTotalValue(price);
    }

    private void computeAndSetTotalValue(List<Order> orders) {

        for (Order order : orders) {
            computeAndSetTotalValue(order);
        }
    }

    private void mapLineItemValueToProduct(Product product) {

        List<LineItem> items = product.getLineItems();

        double value = product.getValue();

        for (LineItem item : items) {
            item.setPrice(value);
        }
    }

    private void mapLineItemValueToProduct(List<Product> products) {

        for (Product product: products) {
            mapLineItemValueToProduct(product);
        }
    }
}
