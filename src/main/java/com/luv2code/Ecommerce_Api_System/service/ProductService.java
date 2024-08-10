package com.luv2code.Ecommerce_Api_System.service;

import com.luv2code.Ecommerce_Api_System.dto.request.CustomerCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.request.CustomerUpdateRequest;
import com.luv2code.Ecommerce_Api_System.dto.request.ProductCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerCreationResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerUpdateResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.ProductCreationResponse;

import java.util.List;

public interface ProductService {
    public ProductCreationResponse createProduct(ProductCreationRequest request);

    public List<ProductCreationResponse> getProduct();

    public ProductCreationResponse getProduct(String productId);

    public ProductCreationResponse updateProduct(String productId, ProductCreationRequest request);

    public void deleteProduct(String productId);


}
