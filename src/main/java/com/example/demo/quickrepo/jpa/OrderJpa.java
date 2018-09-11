package com.example.demo.quickrepo.jpa;

import com.example.demo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpa extends JpaRepository<Order, Long> {
}
