package com.luv2code.Ecommerce_Api_System.mapper;

import com.luv2code.Ecommerce_Api_System.dto.request.ProductCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.request.SellerCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.response.ProductCreationResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.SellerCreationResponse;
import com.luv2code.Ecommerce_Api_System.entity.Product;
import com.luv2code.Ecommerce_Api_System.entity.Seller;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SellerMapper {

    @Mapping(target = "sellerId", ignore = true)
    @Mapping(target = "products", ignore = true)
    Seller toSeller(SellerCreationRequest request);

    @Mapping(source = "products", target = "products")
    SellerCreationResponse toSellerResponse(Seller seller);

    List<SellerCreationResponse> toSellerListResponse(List<Seller> sellerList);
}
