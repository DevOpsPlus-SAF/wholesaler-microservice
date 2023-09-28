package com.ksero.wholesalerservice.wholesalers.domain.model.entity;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "wholesaler")
public class Wholesaler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wholesalerId;

    private String firstName;
    private String lastName;
    private String birthday;
    private String phone;
    private String email;
    private String address;
    private String username;
    private String password;
    private String description;
    private String creditCardNumber;
}
