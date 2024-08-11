package com.luv2code.Ecommerce_Api_System.service.Implement;

import com.luv2code.Ecommerce_Api_System.dto.request.SellerCreationRequest;
import com.luv2code.Ecommerce_Api_System.dto.response.SellerCreationResponse;
import com.luv2code.Ecommerce_Api_System.entity.Product;
import com.luv2code.Ecommerce_Api_System.entity.Seller;
import com.luv2code.Ecommerce_Api_System.exception.ErrorCode;
import com.luv2code.Ecommerce_Api_System.exception.ProductException;
import com.luv2code.Ecommerce_Api_System.exception.SellerException;
import com.luv2code.Ecommerce_Api_System.mapper.ProductMapper;
import com.luv2code.Ecommerce_Api_System.mapper.SellerMapper;
import com.luv2code.Ecommerce_Api_System.repository.ProductRepository;
import com.luv2code.Ecommerce_Api_System.repository.SellerRepository;
import com.luv2code.Ecommerce_Api_System.service.SellerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class SellerServiceImpl implements SellerService {

    SellerRepository sellerRepository;

    SellerMapper sellerMapper;

    ProductMapper productMapper;

    PasswordEncoder passwordEncoder;


    @Override
    public SellerCreationResponse createSeller(SellerCreationRequest request) {
        if (sellerRepository.existsByEmailId(request.getEmailId())) {
            throw new SellerException(ErrorCode.SELLER_EXISTED);
        }

        Seller seller = sellerMapper.toSeller(request);
        seller.setPassword(passwordEncoder.encode(seller.getPassword()));

        List<Product> products = request.getProducts().stream()
                .map(productRequest -> {
                    Product product = productMapper.toProduct(productRequest);
                    product.setSeller(seller); // Gán seller cho từng sản phẩm
                    return product;
                }).collect(Collectors.toList());

        seller.setProducts(products);
        sellerRepository.save(seller);

        return sellerMapper.toSellerResponse(seller);
    }

    @Override
    public List<SellerCreationResponse> getSeller() {
        List<Seller> sellerResponseList = sellerRepository.findAll();
        return sellerMapper.toSellerListResponse(sellerResponseList);
    }

    @Override
    public SellerCreationResponse getSeller(String sellerId) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(()-> new SellerException(ErrorCode.SELLER_NOT_FOUND));

        return sellerMapper.toSellerResponse(seller);
    }

    @Override
    public SellerCreationResponse updateSeller(String sellerId, SellerCreationRequest request) {
        return null;
    }

//    @Override
//    public SellerCreationResponse updateSeller(String sellerId, SellerCreationRequest request) {
//        Seller seller = sellerRepository.findById(sellerId)
//                .orElseThrow(() -> new SellerException(ErrorCode.SELLER_NOT_FOUND));
//
//        if (sellerRepository.existsByEmailId(request.getEmailId())) {
//            throw new SellerException(ErrorCode.SELLER_EXISTED);
//        }
//        sellerMapper.updateSeller(seller, request);
//
//        return sellerMapper.toSellerResponse(sellerRepository.save(seller));
//    }

    @Override
    public void deleteSeller(String sellerId) {
        sellerRepository.findById(sellerId)
                .orElseThrow(()-> new SellerException(ErrorCode.SELLER_NOT_FOUND));

        sellerRepository.deleteById(sellerId);
    }
}
