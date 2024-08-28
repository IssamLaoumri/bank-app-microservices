package com.laoumri.accountservice.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    private Long id;
    private String firstname;
    private String lastName;
    private String email;
}
