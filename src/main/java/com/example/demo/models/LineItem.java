package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "LINEITEM")
public class LineItem {
    @Id
    @GeneratedValue
    @Column(name = "LINEITEMID")
    private Long lineItemId;

    @Column(name = "ORDERID")
    private Long orderId;

    @Column(name = "PRODUCTID")
    private Long productId;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "RATE")
    private Double rate;

    @Column(name = "QUANTITY")
    private Long quantity;

    @Column(name = "NAME")
    private String name;

    public LineItem() {
    }

    public Long getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(Long lineItemId) {
        this.lineItemId = lineItemId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}