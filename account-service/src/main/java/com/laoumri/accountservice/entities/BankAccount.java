package com.laoumri.accountservice.entities;

import com.laoumri.accountservice.enums.AccountType;
import com.laoumri.accountservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class BankAccount {
    @Id
    private String accountId;
    private Double balance;
    private String currency;
    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Transient
    private Customer customer;
    private Long customerId;
}
