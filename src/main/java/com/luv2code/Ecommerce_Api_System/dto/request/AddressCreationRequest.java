package com.luv2code.Ecommerce_Api_System.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luv2code.Ecommerce_Api_System.entity.Customer;
import jakarta.persistence.*;
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
public class AddressCreationRequest {

    @Pattern(regexp = "[A-Za-z0-9\\s-]{3,}", message = "Not a valid street no")
    private String streetNo;

    @Pattern(regexp = "[A-Za-z0-9\\s-]{3,}", message = "Not a valid building name")
    private String buildingName;

    @NotNull
    @Pattern(regexp = "[A-Za-z0-9\\s-]{3,}", message ="Not a valid lacality name")
    private String locality;

    @NotNull(message = "City name cannot be null")
    @Pattern(regexp = "[A-Za-z\\s]{2,}", message = "Not a valid city name")
    private String city;

    @NotNull(message = "State name cannot be null")
    private String state;

    @NotNull(message = "Pin code cannot be null")
    @Pattern(regexp = "[0-9]{6}", message = "Pin code not valid. Must be 6 digits")
    private String pin_code;

    private List<Customer> customer;
}
