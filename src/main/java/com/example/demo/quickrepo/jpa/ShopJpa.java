package com.example.demo.quickrepo.jpa;

import com.example.demo.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopJpa extends JpaRepository<Shop, Long> {
}
