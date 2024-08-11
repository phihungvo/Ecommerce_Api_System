package com.luv2code.Ecommerce_Api_System.service;

import com.luv2code.Ecommerce_Api_System.dto.request.ProductCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.request.SellerCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.response.ProductCreationResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.SellerCreationResponse;

import java.util.List;

public interface SellerService {

    public SellerCreationResponse createSeller(SellerCreationRequest request);

    public List<SellerCreationResponse> getSeller();

    public SellerCreationResponse getSeller(String sellerId);

    public SellerCreationResponse updateSeller(String sellerId, SellerCreationRequest request);

    public void deleteSeller(String sellerId);

}
