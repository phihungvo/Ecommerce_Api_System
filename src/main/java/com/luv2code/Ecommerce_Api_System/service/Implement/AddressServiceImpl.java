package com.luv2code.Ecommerce_Api_System.service.Implement;

import com.luv2code.Ecommerce_Api_System.dto.request.CustomerCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.request.CustomerUpdateRequest;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerCreationResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerUpdateResponse;
import com.luv2code.Ecommerce_Api_System.entity.Address;
import com.luv2code.Ecommerce_Api_System.entity.Customer;
import com.luv2code.Ecommerce_Api_System.exception.AppException;
import com.luv2code.Ecommerce_Api_System.exception.CustomerException;
import com.luv2code.Ecommerce_Api_System.exception.ErrorCode;
import com.luv2code.Ecommerce_Api_System.mapper.CustomerMapper;
import com.luv2code.Ecommerce_Api_System.repository.AddressRepository;
import com.luv2code.Ecommerce_Api_System.repository.CustomerRepository;
import com.luv2code.Ecommerce_Api_System.service.AddressService;
import com.luv2code.Ecommerce_Api_System.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }


    @Override
    public List<Address> getAddress() {
        List<Address> address =  addressRepository.findAll();
        return address;
    }


}
