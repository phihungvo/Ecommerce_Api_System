package com.luv2code.Ecommerce_Api_System.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luv2code.Ecommerce_Api_System.entity.Address;
import com.luv2code.Ecommerce_Api_System.entity.Seller;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCreationRequest {

    @NotNull
    @Size(min = 3, max = 30, message = "Product name size should be between 3-30")
    private String productName;

    @NotNull
    @DecimalMin(value = "0.00")
    private Double price;

    private String description;

    @NotNull
    private String manufacturer;

    @NotNull
    @Min(value = 0)
    private Integer quantity;

}
