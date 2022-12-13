package com.project.service.account;

import com.project.model.account.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAllAccount();

    Account findByUsername(String username);


    void sendMail(String email, String username, String passwordResetToken);

}
