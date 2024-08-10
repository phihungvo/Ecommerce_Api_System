package com.luv2code.Ecommerce_Api_System.mapper;

import com.luv2code.Ecommerce_Api_System.dto.request.CustomerUpdateRequest;
import com.luv2code.Ecommerce_Api_System.dto.request.ProductCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerCreationResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.CustomerUpdateResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.ProductCreationResponse;
import com.luv2code.Ecommerce_Api_System.entity.Customer;
import com.luv2code.Ecommerce_Api_System.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductCreationRequest request);

    ProductCreationResponse toProductResponse(Product product);

    List<ProductCreationResponse> toProductCreationResponseList(List<Product> productList);

    void updateProduct(@MappingTarget Product product, ProductCreationRequest request);


}
