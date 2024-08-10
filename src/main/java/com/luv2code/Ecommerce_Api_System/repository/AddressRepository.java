package com.luv2code.Ecommerce_Api_System.repository;

import com.luv2code.Ecommerce_Api_System.entity.Address;
import com.luv2code.Ecommerce_Api_System.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

}
