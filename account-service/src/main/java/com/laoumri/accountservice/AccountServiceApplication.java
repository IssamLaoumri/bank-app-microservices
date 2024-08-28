package com.laoumri.accountservice;

import com.laoumri.accountservice.entities.BankAccount;
import com.laoumri.accountservice.enums.AccountType;
import com.laoumri.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){
        return args -> {
            List<BankAccount> accountList = List.of(
                    BankAccount.builder()
                            .accountId(UUID.randomUUID().toString())
                            .balance(98000.00)
                            .currency("MAD")
                            .createdAt(LocalDate.now())
                            .type(AccountType.CURRENT_ACCOUNT)
                            .customerId(1L)
                            .build(),
                    BankAccount.builder()
                            .accountId(UUID.randomUUID().toString())
                            .balance(12000.00)
                            .currency("MAD")
                            .createdAt(LocalDate.now())
                            .type(AccountType.SAVING_ACCOUNT)
                            .customerId(2L)
                            .build(),
                    BankAccount.builder()
                            .accountId(UUID.randomUUID().toString())
                            .balance(9000.50)
                            .currency("MAD")
                            .createdAt(LocalDate.now())
                            .type(AccountType.CURRENT_ACCOUNT)
                            .customerId(3L)
                            .build()
            );
            bankAccountRepository.saveAll(accountList);
        };
    }
}
