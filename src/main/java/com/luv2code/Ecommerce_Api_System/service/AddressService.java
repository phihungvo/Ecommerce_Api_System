package com.luv2code.Ecommerce_Api_System.service;

import com.luv2code.Ecommerce_Api_System.dto.request.AddressCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.request.CustomerCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.request.CustomerUpdateRequest;
import com.luv2code.Ecommerce_Api_System.dto.response.AddressCreationResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerCreationResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerUpdateResponse;
import com.luv2code.Ecommerce_Api_System.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    public AddressCreationResponse createAddress(AddressCreationRequest request);

    public List<AddressCreationResponse> getAddress();

    public AddressCreationResponse getAddress(String addressId);

    public AddressCreationResponse updateAddress(String addressId, AddressCreationRequest request);

    public void deleteAddress(String addressId);
}
