package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "PRODUCTID")
    private Long productId;

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="PRODUCTID")
    private List<LineItem> lineItems;

    @Column(name = "VALUE")
    private Double value;

    @Column(name = "NAME")
    private String name;

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
