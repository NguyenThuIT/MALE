package com.machinelearning.demo.repository;

import com.machinelearning.demo.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
