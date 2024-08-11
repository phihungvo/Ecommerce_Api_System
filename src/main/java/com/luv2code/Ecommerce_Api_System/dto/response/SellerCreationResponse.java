package com.luv2code.Ecommerce_Api_System.dto.response;

import com.luv2code.Ecommerce_Api_System.entity.Product;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellerCreationResponse {

    private String firstName;

    private String lastName;

    private String mobile;

    private String emailId;

    private List<ProductCreationResponse> products;
}
