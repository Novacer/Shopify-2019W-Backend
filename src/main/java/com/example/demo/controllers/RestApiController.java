package com.example.demo.controllers;

import com.example.demo.models.LineItem;
import com.example.demo.models.Order;
import com.example.demo.models.Product;
import com.example.demo.models.Shop;
import com.example.demo.quickrepo.jpa.DataRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class RestApiController {

    private final DataRepository dataRepository;

    public RestApiController(DataRepository quickDataRepository) {
        this.dataRepository = quickDataRepository;
    }

    @GetMapping("/")
    @ApiOperation(value = "Used only to redirect to swagger UI")
    public ModelAndView redirect() {
        return new ModelAndView("redirect:/swagger-ui.html");
    }

    @GetMapping("/api/shop/{shopId}")
    @ApiOperation(value = "Get all info for a shop from its ID")
    public Shop getShop(@ApiParam(value = "The Shop ID. When in doubt use 1.")
                            @PathVariable Long shopId) {

        Shop shop = dataRepository.getShopById(shopId);

        computeAndSetTotalValue(shop.getOrders());
        mapLineItemValueToProduct(shop.getProducts());

        return shop;
    }

    @GetMapping("/api/shop/{shopId}/product")
    @ApiOperation(value = "Get all products for a shop")
    public ProductsListWrapper getAllProducts(@ApiParam(value = "The Shop ID. When in doubt use 1.")
                                                  @PathVariable Long shopId) {

        Shop shop = dataRepository.getShopById(shopId);

        List<Product> products = shop.getProducts();

        mapLineItemValueToProduct(products);

        return new ProductsListWrapper(products);
    }

    @GetMapping("/api/shop/{shopId}/order")
    @ApiOperation(value = "Get all orders for a shop")
    public OrdersListWrapper getAllOrders(@ApiParam(value = "The Shop ID. When in doubt use 1.")
                                              @PathVariable Long shopId) {

        Shop shop = dataRepository.getShopById(shopId);

        List<Order> orders = shop.getOrders();

        computeAndSetTotalValue(orders);

        return new OrdersListWrapper(orders);
    }


    @GetMapping("/api/shop/{shopId}/order/{orderId}")
    @ApiOperation(value = "Get a specific order for a shop")
    public Order getOrder(@ApiParam(value = "The Order ID. When in doubt use 1.")
                              @PathVariable Long orderId,
                          @ApiParam(value = "The Shop ID. When in doubt use 1.")
                              @PathVariable Long shopId)
            throws EntityNotFoundException{

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
    @ApiOperation(value = "Get a specific product for a shop")
    public Product getProduct(@ApiParam(value = "The Product ID. When in doubt use 1.")
                                  @PathVariable Long productId,
                              @ApiParam(value = "The Shop ID. When in doubt use 1.")
                                  @PathVariable Long shopId) throws EntityNotFoundException {

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


    /**
     * sums the prices of an order and modifies the total value field to be that value
     * @param order an order
     */
    private void computeAndSetTotalValue(Order order) {

        List<LineItem> items = order.getLineItems();

        double price = 0;

        for (LineItem item : items) {
            price += item.getPrice();
        }

        order.setTotalValue(price);
    }


    /**
     * computes and sets the correct total value for a list of orders
     * @param orders a list of orders
     */
    private void computeAndSetTotalValue(List<Order> orders) {

        for (Order order : orders) {
            computeAndSetTotalValue(order);
        }
    }


    /**
     * modifies all of the LineItems to have the same price as the product's value
     * @param product a product
     */
    private void mapLineItemValueToProduct(Product product) {

        List<LineItem> items = product.getLineItems();

        double value = product.getValue();

        for (LineItem item : items) {
            item.setPrice(value);
        }
    }


    /**
     * modifies all of the LineItems in each product to have the same price as the product's value
     * @param products a list of products
     */
    private void mapLineItemValueToProduct(List<Product> products) {

        for (Product product: products) {
            mapLineItemValueToProduct(product);
        }
    }
}
