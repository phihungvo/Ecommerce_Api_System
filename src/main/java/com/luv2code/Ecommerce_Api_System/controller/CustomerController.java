package com.luv2code.Ecommerce_Api_System.controller;

import com.luv2code.Ecommerce_Api_System.dto.request.CustomerCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.request.CustomerUpdateRequest;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerCreationResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerUpdateResponse;
import com.luv2code.Ecommerce_Api_System.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerCreationResponse> createCustomer(@Valid @RequestBody CustomerCreationRequest request){
        return ResponseEntity.ok()
                .body(customerService.createCustomer(request));
    }

    @GetMapping
    public ResponseEntity<List<CustomerCreationResponse>> getCustomer(){
        return ResponseEntity.ok()
                .body(customerService.getCustomer());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerCreationResponse> getCustomer(@PathVariable String customerId){
        return ResponseEntity.ok()
                .body(customerService.getCustomer(customerId));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerUpdateResponse> updateCustomer(@PathVariable String customerId
                                        ,@RequestBody CustomerUpdateRequest request){
        return ResponseEntity.ok()
                .body(customerService.updateCustomer(customerId, request));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String customerId){
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok().body("Customer deleted successfully!");
    }


}

