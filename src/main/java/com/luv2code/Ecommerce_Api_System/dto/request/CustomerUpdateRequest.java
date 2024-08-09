package com.luv2code.Ecommerce_Api_System.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerUpdateRequest {

    @NotNull(message = "First name cannot be null")
    @Pattern(regexp = "[A-Za-z.\\s]+", message = "Enter valid characters in first name")
    String firstName;

    @NotNull(message = "Last name cannot be null")
    @Pattern(regexp = "[A-Za-z.\\s]+", message = "Enter valid characters in last name")
    String lastName;

    @NotNull(message = "Please enter the password")
    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}", message = "Password must be 8-15 characters in length and can include A-Z, a-z, 0-9, or special characters !@#$%^&*_")
    String password;

    LocalDateTime createdOn = LocalDateTime.now();
}
