package com.luv2code.Ecommerce_Api_System.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;

    private String productName;

    private Double price;

    private String description;

    private String manufacturer;

    private Integer quantity;

//    @Enumerated(EnumType.STRING)
//    private CategoryEnum category;
//
//    @Enumerated(EnumType.STRING)
//    private ProductStatus status;
}
