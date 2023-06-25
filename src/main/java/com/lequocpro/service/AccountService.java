package com.lequocpro.service;

import com.lequocpro.entity.Account;

public interface AccountService {
    Account findByUserName(String userName);

    Account createAccount(Account account);
}
