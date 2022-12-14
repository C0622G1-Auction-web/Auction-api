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

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create account
     * @return Account
     */
    @Override
    public Account createAccount(Account account) {
       return   accountRepository.createAccount(
                account.getUsername(),
                account.getPassword());
    }

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to update account
     * @return Account
     */
    @Override
    public Account updateAddress(Account account) {
       return   accountRepository.updateAccount(
                account.getUsername(),
                account.getPassword());
    }
}
