package com.luv2code.Ecommerce_Api_System.dto.request;

import com.luv2code.Ecommerce_Api_System.entity.Product;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellerCreationRequest {


    @NotNull(message="Please enter the first name")
    @Pattern(regexp="[A-Za-z\\s]+", message="First Name should contain alphabets only")
    private String firstName;

    @NotNull(message="Please enter the last name")
    @Pattern(regexp="[A-Za-z\\s]+", message="Last Name should contain alphabets only")
    private String lastName;

    @NotNull(message="Please enter your password")
    @Pattern(regexp="[A-Za-z0-9!@#$%^&*_]{8,15}", message="Please enter a valid password")
    private String password;

    @NotNull(message="Please enter your mobile number")
    @Pattern(regexp="[6789]{1}[0-9]{9}", message="Enter a valid mobile number")
    private String mobile;

    @Email(message="Please enter a valid email")
    private String emailId;

    private List<ProductCreationRequest> products = new ArrayList<>();
}
