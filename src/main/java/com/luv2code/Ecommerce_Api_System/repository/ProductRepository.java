package com.luv2code.Ecommerce_Api_System.repository;

import com.luv2code.Ecommerce_Api_System.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    boolean existsByProductName(String productName);
}
