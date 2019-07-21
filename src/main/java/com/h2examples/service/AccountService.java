package com.h2examples.service;

import com.h2examples.domain.Account;
import com.h2examples.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account saveOrUpdate(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(accounts::add);
        return accounts;
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id).get();
    }

    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
}
