package com.ksero.wholesalerservice.wholesalers.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateWholesalerResource {
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
