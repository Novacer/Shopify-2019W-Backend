package com.example.demo.quickrepo.jpa;

import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpa extends JpaRepository<Product, Long> {
}
