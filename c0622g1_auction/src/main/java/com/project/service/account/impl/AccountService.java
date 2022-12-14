package com.project.service.account.impl;

import com.project.model.account.Account;
import com.project.repository.account.IAccountRepository;
import com.project.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }
}
