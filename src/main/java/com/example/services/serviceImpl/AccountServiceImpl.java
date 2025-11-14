package com.example.services.serviceImpl;

import com.example.Entity.Account;
import com.example.services.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    @Override
    public Account createAccount(Account account) {
        return null;
    }

    @Override
    public Account getAccountDetailsByAccountNumber(Long accountNumber) {
        return null;
    }

    @Override
    public List<Account> getAllAccountDetails() {
        return null;
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
        return null;
    }

    @Override
    public Account withdrwaAmount(Long accountNumber, Double amount) {
        return null;
    }

    @Override
    public void closeAccount(Long accountNumber) {

    }
}
