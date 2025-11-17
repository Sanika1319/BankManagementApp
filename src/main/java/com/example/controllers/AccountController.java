package com.example.controllers;

import com.example.Entity.Account;
import com.example.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account createAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);

    }

    @GetMapping("/{accountNumber}")

    public Account getAccountByAccountNumber(@PathVariable Long accountNumber){
        Account account = accountService.getAccountDetailsByAccountNumber(accountNumber);
        return account;
    }
    @GetMapping("/getallaccounts")

    public List<Account> getAllAccountDetails(){
        List<Account> allAccountDetails = accountService.getAllAccountDetails();
        return allAccountDetails;
    }

    @PutMapping("deposite/{accountNumber}/{amount}")
    public Account deposteAccount(@PathVariable Long accountNumber,@PathVariable Double amount){
        Account account = accountService.depositAmount(accountNumber, amount);
        return account;
    }


    @PutMapping("withdraw/{accountNumber}/{amount}")
    public Account withdrawAccount(@PathVariable Long accountNumber,@PathVariable Double amount){
        Account account = accountService.withdrwaAmount(accountNumber, amount);
        return account;
    }

    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<String > deleteAccount(@PathVariable Long accountNumber){
        accountService.closeAccount(accountNumber);
        return ResponseEntity.ok("Account Closed");
    }

}
