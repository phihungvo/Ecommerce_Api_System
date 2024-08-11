package com.luv2code.Ecommerce_Api_System.repository;

import com.luv2code.Ecommerce_Api_System.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, String> {
    boolean existsByEmailId(String emailId);
}
