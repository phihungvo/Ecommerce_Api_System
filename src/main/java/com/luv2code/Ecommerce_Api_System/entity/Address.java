package com.luv2code.Ecommerce_Api_System.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String addressId;

    private String streetNo;

    private String buildingName;

    private String locality;

    private String city;

    private String state;

    private String pin_code;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Customer customer;
}
