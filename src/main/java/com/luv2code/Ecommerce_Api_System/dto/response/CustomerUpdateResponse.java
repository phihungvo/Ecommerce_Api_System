package com.luv2code.Ecommerce_Api_System.dto.response;

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
public class CustomerUpdateResponse {

    String firstName;

    String lastName;

    String password;

    LocalDateTime createdOn;
}
