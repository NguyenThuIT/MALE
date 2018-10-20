package com.machinelearning.demo.repository;

import com.machinelearning.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Integer countProductsByCategoryId(int productId);
}
