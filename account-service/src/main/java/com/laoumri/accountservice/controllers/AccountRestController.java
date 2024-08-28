package com.laoumri.accountservice.controllers;

import com.laoumri.accountservice.clients.CustomerRestClient;
import com.laoumri.accountservice.entities.BankAccount;
import com.laoumri.accountservice.models.Customer;
import com.laoumri.accountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private final BankAccountRepository bankAccountRepository;
    private final CustomerRestClient customerRestClient;

    @Autowired
    public AccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        List<BankAccount> accounts = bankAccountRepository.findAll();
        accounts.forEach(acc-> {
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });
        return accounts;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount accountById(@PathVariable String id){
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
