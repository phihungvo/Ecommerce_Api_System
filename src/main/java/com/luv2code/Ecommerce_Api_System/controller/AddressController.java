package com.luv2code.Ecommerce_Api_System.controller;

import com.luv2code.Ecommerce_Api_System.dto.request.CustomerCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.request.CustomerUpdateRequest;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerCreationResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerUpdateResponse;
import com.luv2code.Ecommerce_Api_System.entity.Address;
import com.luv2code.Ecommerce_Api_System.service.AddressService;
import com.luv2code.Ecommerce_Api_System.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> createCustomer(@Valid @RequestBody Address request){
        return ResponseEntity.ok()
                .body(addressService.createAddress(request));
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAddress(){
        return ResponseEntity.ok().body(addressService.getAddress());
    }



}

