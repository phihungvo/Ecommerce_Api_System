package com.luv2code.Ecommerce_Api_System.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String firstName;

    String lastName;

    String mobileNo;

    String emailId;

    String password;

    LocalDateTime createdOn;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "customer_address_mapping",
            joinColumns = {
                     @JoinColumn(name = "customer_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
            }
    )
    Map<String, Address> address = new HashMap<>();
}
