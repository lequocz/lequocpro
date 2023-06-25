package com.lequocpro.service.impl;

import com.lequocpro.entity.Account;
import com.lequocpro.repository.AccountRepository;
import com.lequocpro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Account findByUserName(String userName) {
        return accountRepository.findByUsername(userName);
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }
}
