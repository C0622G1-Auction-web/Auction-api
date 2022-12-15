package com.project.service.account;
import com.project.model.account.Account;

import java.util.List;



import com.project.model.account.Account;

public interface IAccountService {
    Account saveAccount(Account account);

    List<Account> findAllAccount();

    Account findByUsername(String username);


    void sendMail(String email, String username, String passwordResetToken);

    Account findById(Integer id);

    void save(Account account);
}
