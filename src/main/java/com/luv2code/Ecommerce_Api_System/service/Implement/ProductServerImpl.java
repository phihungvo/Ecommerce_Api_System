package com.luv2code.Ecommerce_Api_System.service.Implement;

import com.luv2code.Ecommerce_Api_System.dto.request.ProductCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.response.ProductCreationResponse;
import com.luv2code.Ecommerce_Api_System.entity.Product;
import com.luv2code.Ecommerce_Api_System.exception.ErrorCode;
import com.luv2code.Ecommerce_Api_System.exception.ProductException;
import com.luv2code.Ecommerce_Api_System.mapper.ProductMapper;
import com.luv2code.Ecommerce_Api_System.repository.ProductRepository;
import com.luv2code.Ecommerce_Api_System.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServerImpl implements ProductService {

    ProductRepository productRepository;

    ProductMapper productMapper;



    @Override
    public ProductCreationResponse createProduct(ProductCreationRequest request) {
        if (productRepository.existsByProductName(request.getProductName())) {
            throw new ProductException(ErrorCode.PRODUCT_EXISTED);
        }

        Product product = productMapper.toProduct(request);
        productRepository.save(product);

        return productMapper.toProductResponse(product);
    }

    @Override
    public List<ProductCreationResponse> getProduct() {
        List<Product> productResponseList = productRepository.findAll();
        return productMapper.toProductCreationResponseList(productResponseList);
    }

    @Override
    public ProductCreationResponse getProduct(String productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ProductException(ErrorCode.USER_NOT_EXISTED));

        return productMapper.toProductResponse(product);
    }


    @Override
    public ProductCreationResponse updateProduct(String productId, ProductCreationRequest request) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductException(ErrorCode.USER_NOT_EXISTED));  // Lỗi ở đây, nên dùng ERROR_CODE_PRODUCT_NOT_FOUND

        if(productRepository.existsByProductName(request.getProductName())){
            throw new ProductException(ErrorCode.PRODUCT_EXISTED);
        }
        productMapper.updateProduct(product, request);

        return productMapper.toProductResponse(productRepository.save(product));
    }

//    @Override
//    public ProductCreationResponse updateProduct(String productId, ProductCreationRequest request) {
//        Product product = productRepository.findById(productId)
//                .orElseThrow(()-> new ProductException(ErrorCode.USER_NOT_EXISTED));
//
//        if(productRepository.existsByProductName(request.getProductName())){
//            throw new ProductException(ErrorCode.PRODUCT_EXISTED);
//        }
//        productMapper.updateProduct(product, request);
//
//        return productMapper.toProductResponse(productRepository.save(product));
//    }

    @Override
    public void deleteProduct(String productId) {
        productRepository.findById(productId)
                .orElseThrow(()-> new ProductException(ErrorCode.USER_NOT_EXISTED));

        productRepository.deleteById(productId);
    }
}
