package com.luv2code.Ecommerce_Api_System.service.Implement;

import com.luv2code.Ecommerce_Api_System.dto.request.CustomerCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.request.CustomerUpdateRequest;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerCreationResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerUpdateResponse;
import com.luv2code.Ecommerce_Api_System.entity.Customer;
import com.luv2code.Ecommerce_Api_System.exception.CustomerException;
import com.luv2code.Ecommerce_Api_System.exception.ErrorCode;
import com.luv2code.Ecommerce_Api_System.mapper.CustomerMapper;
import com.luv2code.Ecommerce_Api_System.repository.CustomerRepository;
import com.luv2code.Ecommerce_Api_System.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CustomerCreationResponse createCustomer(CustomerCreationRequest request) {
        boolean customerExisted = customerRepository.existsByEmailId(request.getEmailId());
        if(customerExisted){
            throw new CustomerException(ErrorCode.USER_EXISTED);
        }
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        Customer newCustomer = customerRepository.save(customerMapper.creationRequestToCustomer(request));

        return customerMapper.toCustomerCreationResponse(newCustomer);
    }

    @Override
    public CustomerCreationResponse getCustomer(String customerId) {
        Customer customer =  customerRepository.findById(customerId)
                .orElseThrow(()-> new CustomerException(ErrorCode.USER_NOT_EXISTED));
        return customerMapper.toCustomerCreationResponse(customer);
    }

    @Override
    public List<CustomerCreationResponse> getCustomer(){
        List<Customer> customerList =  customerRepository.findAll();
        return customerMapper.toCustomerCreationResponseList(customerList);
    }


    @Override
    public CustomerUpdateResponse updateCustomer(String customerId, CustomerUpdateRequest request) {
        Customer customer =  customerRepository.findById(customerId)
                .orElseThrow(()-> new CustomerException(ErrorCode.USER_NOT_EXISTED));

        customerMapper.updateCustomer(customer, request);

        customer.setPassword(passwordEncoder.encode(request.getPassword()));

        customerRepository.save(customer);

        return customerMapper.customerToCustomUpdateRes(customer);
    }

    @Override
    public void deleteCustomer(String customerId) {
        Customer customer =  customerRepository.findById(customerId)
                .orElseThrow(()-> new CustomerException(ErrorCode.USER_NOT_EXISTED));

        customerRepository.deleteById(customerId);
    }
}
