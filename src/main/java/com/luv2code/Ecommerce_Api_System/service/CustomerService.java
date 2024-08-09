package com.luv2code.Ecommerce_Api_System.service;

import com.luv2code.Ecommerce_Api_System.dto.request.CustomerCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.request.CustomerUpdateRequest;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerCreationResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerUpdateResponse;

import java.util.List;

public interface CustomerService {
    public CustomerCreationResponse createCustomer(CustomerCreationRequest request);

    public List<CustomerCreationResponse> getCustomer();

    public CustomerCreationResponse getCustomer(String customerId);

    public CustomerUpdateResponse updateCustomer(String customerId, CustomerUpdateRequest request);

    public void deleteCustomer(String customerId);
}
