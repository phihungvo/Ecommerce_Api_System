package com.luv2code.Ecommerce_Api_System.controller;

import com.luv2code.Ecommerce_Api_System.dto.request.ProductCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.response.ApiResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.ProductCreationResponse;
import com.luv2code.Ecommerce_Api_System.service.ProductService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    ProductService productService;

    @PostMapping
    public ApiResponse<ProductCreationResponse> createProduct(@Valid @RequestBody ProductCreationRequest request){
        return ApiResponse.<ProductCreationResponse>builder()
                .result(productService.createProduct(request))
                .build();
    }

    @GetMapping()
    public ApiResponse<List<ProductCreationResponse>> getProduct(){
        return ApiResponse.<List<ProductCreationResponse>>builder()
                .result(productService.getProduct())
                .build();
    }

    @GetMapping("/{productId}")
    public ApiResponse<ProductCreationResponse> getProduct(@PathVariable String productId){
        return ApiResponse.<ProductCreationResponse>builder()
                .result(productService.getProduct(productId))
                .build();
    }


    @PutMapping("/{productId}")
    public ApiResponse<ProductCreationResponse> updateProduct(@PathVariable String productId,
                                                              @Valid @RequestBody ProductCreationRequest request){
        return ApiResponse.<ProductCreationResponse>builder()
                .result(productService.updateProduct(productId, request))
                .build();
    }

    @DeleteMapping("/{productId}")
    public ApiResponse<String> deleteProduct(@PathVariable String productId){
        productService.deleteProduct(productId);
        return ApiResponse.<String>builder()
                .message("Product has been deleted!!!")
                .build();
    }
}
