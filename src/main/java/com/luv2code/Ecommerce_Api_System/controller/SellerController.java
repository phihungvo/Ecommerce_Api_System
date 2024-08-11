package com.luv2code.Ecommerce_Api_System.controller;

import com.luv2code.Ecommerce_Api_System.dto.request.ProductCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.request.SellerCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.response.ApiResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.ProductCreationResponse;
import com.luv2code.Ecommerce_Api_System.dto.response.SellerCreationResponse;
import com.luv2code.Ecommerce_Api_System.service.ProductService;
import com.luv2code.Ecommerce_Api_System.service.SellerService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@RequestMapping("/api/v1/sellers")
public class SellerController {

    SellerService sellerService;

//    @PostMapping
//    public ApiResponse<SellerCreationResponse> createProduct(@Valid @RequestBody SellerCreationRequest request){
//        return ApiResponse.<SellerCreationResponse>builder()
//                .result(sellerService.createSeller(request))
//                .build();
//    }

//    @PostMapping
//    public ResponseEntity<SellerCreationResponse> createSeller(@RequestBody SellerCreationRequest request) {
//        SellerCreationResponse response = sellerService.createSeller(request);
//        return ResponseEntity.ok(response);
//    }
@PostMapping
public ResponseEntity<SellerCreationResponse> createSeller(@Valid @RequestBody SellerCreationRequest request) {
    SellerCreationResponse response = sellerService.createSeller(request);
    return ResponseEntity.ok(response);
}

    @GetMapping()
    public ApiResponse<List<SellerCreationResponse>> getProduct(){
        return ApiResponse.<List<SellerCreationResponse>>builder()
                .result(sellerService.getSeller())
                .build();
    }

    @GetMapping("/{sellerId}")
    public ApiResponse<SellerCreationResponse> getProduct(@PathVariable String sellerId){
        return ApiResponse.<SellerCreationResponse>builder()
                .result(sellerService.getSeller(sellerId))
                .build();
    }


    @PutMapping("/{sellerId}")
    public ApiResponse<SellerCreationResponse> updateProduct(@PathVariable String sellerId,
                                                              @Valid @RequestBody SellerCreationRequest request){
        return ApiResponse.<SellerCreationResponse>builder()
                .result(sellerService.updateSeller(sellerId, request))
                .build();
    }

    @DeleteMapping("/{sellerId}")
    public ApiResponse<String> deleteProduct(@PathVariable String sellerId){
        sellerService.deleteSeller(sellerId);
        return ApiResponse.<String>builder()
                .message("Seller has been deleted!!!")
                .build();
    }
}
