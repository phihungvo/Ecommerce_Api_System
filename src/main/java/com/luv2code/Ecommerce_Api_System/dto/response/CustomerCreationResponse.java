package com.luv2code.Ecommerce_Api_System.dto.response;

import com.luv2code.Ecommerce_Api_System.entity.Address;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerCreationResponse {

    String firstName;

    String lastName;

    String mobileNo;

    String emailId;

    String password;

    LocalDateTime createdOn;

    List<Address> addressList;
}
