package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "LINEITEM")
public class LineItem {
    @Id
    @GeneratedValue
    @Column(name = "LINEITEMID")
    private Long lineItemId;

    @Column(name = "PARENTID")
    private Long parentId;

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

    public LineItem(Long parentId, Double price, Double rate, Long quantity, String name) {
        this.parentId = parentId;
        this.price = price;
        this.rate = rate;
        this.quantity = quantity;
        this.name = name;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}