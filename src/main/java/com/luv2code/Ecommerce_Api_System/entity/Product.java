package com.luv2code.Ecommerce_Api_System.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    String productId;

    String productName;

    Double price;

    String description;

    String manufacturer;

    Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    Seller seller;

}
