package com.luv2code.Ecommerce_Api_System.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String sellerId;

    String firstName;

    String lastName;

    String password;

    @Column(unique = true)
    String mobile;

    @Column(unique = true)
    String emailId;

    // Lớp Seller
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Product> products = new ArrayList<>();
}
