package com.luv2code.Ecommerce_Api_System.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luv2code.Ecommerce_Api_System.entity.Customer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
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
public class AddressCreationResponse {

    private String streetNo;

    private String buildingName;

    private String locality;

    private String city;

    private String state;

    private String pin_code;

    private List<Customer> customer;
}
