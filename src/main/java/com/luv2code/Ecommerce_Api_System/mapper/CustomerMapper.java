package com.luv2code.Ecommerce_Api_System.mapper;

import com.luv2code.Ecommerce_Api_System.dto.request.CustomerCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.request.CustomerUpdateRequest;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerCreationResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerUpdateResponse;
import com.luv2code.Ecommerce_Api_System.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer creationRequestToCustomer(CustomerCreationRequest request);

    CustomerCreationResponse toCustomerCreationResponse(Customer customer);

    List<CustomerCreationResponse> toCustomerCreationResponseList(List<Customer> customerList);

    void updateCustomer(@MappingTarget Customer customer, CustomerUpdateRequest request);

    CustomerUpdateResponse customerToCustomUpdateRes(Customer customer);
}
