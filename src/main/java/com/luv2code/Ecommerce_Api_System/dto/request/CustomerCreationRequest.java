package com.luv2code.Ecommerce_Api_System.dto.request;

import com.luv2code.Ecommerce_Api_System.entity.Address;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerCreationRequest {

    @NotNull(message = "First name cannot be null")
    @Pattern(regexp = "[A-Za-z.\\s]+", message = "Enter valid characters in first name")
    String firstName;

    @NotNull(message = "Last name cannot be null")
    @Pattern(regexp = "[A-Za-z.\\s]+", message = "Enter valid characters in last name")
    String lastName;

    @NotNull(message = "Please enter the mobile number")
    @Pattern(regexp = "^(03|05|07|08|09)[0-9]{8}$", message = "Enter a valid 10-digit mobile number starting with 03, 05, 07, 08, or 09")
    String mobileNo;

    @NotNull(message = "Please enter the mobile number")
    @Email
    String emailId;

    @NotNull(message = "Please enter the password")
    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}", message = "Password must be 8-15 characters in length and can include A-Z, a-z, 0-9, or special characters !@#$%^&*_")
    String password;

    LocalDateTime createdOn = LocalDateTime.now();

    Map<String, Address> address;
}
