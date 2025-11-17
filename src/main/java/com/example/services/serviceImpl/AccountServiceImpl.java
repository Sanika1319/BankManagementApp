package com.example.services.serviceImpl;

import com.example.Entity.Account;
import com.example.repository.AccountRepository;
import com.example.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

   @Autowired
    AccountRepository accountRepository;
    @Override
    public Account createAccount(Account account) {
        Account accountSaved = accountRepository.save(account);
        return accountSaved;
    }

    @Override
    public Account getAccountDetailsByAccountNumber(Long accountNumber) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account does not exist");

        }
        Account account_found = account.get();
        return account_found;
    }

    @Override
    public List<Account> getAllAccountDetails() {
        List<Account> ListOfAccounts = accountRepository.findAll();
        return ListOfAccounts;
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if (account.isEmpty()){
            throw new RuntimeException("Account is not present");
        }
        Account accountPresent = account.get();
        Double totalBalance = accountPresent.getAccount_balanace() + amount;
        accountPresent.setAccount_balanace(totalBalance);
        accountRepository.save(accountPresent);
        return accountPresent;
    }

    @Override
    public Account withdrwaAmount(Long accountNumber, Double amount) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if (account.isEmpty()){
            throw new RuntimeException("Account is not present");
        }
        Account accountPresent = account.get();
        Double accountBalance = accountPresent.getAccount_balanace() - amount;
        accountPresent.setAccount_balanace(accountBalance);
        accountRepository.save(accountPresent);
        return accountPresent;

    }

    @Override
    public void closeAccount(Long accountNumber) {
        getAccountDetailsByAccountNumber(accountNumber);
        accountRepository.deleteById(accountNumber);
    }
}
