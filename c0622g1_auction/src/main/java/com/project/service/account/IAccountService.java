package com.project.service.account;
import com.project.model.account.Account;

import java.util.List;


<<<<<<< HEAD
import com.project.model.account.Account;

public interface IAccountService {

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create account
     * @return Account
     */
    Account createAccount(Account account);

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to update account
     * @return Account
     */
    Account updateAccount(Account account);

    Account findAccountByUsername(String username);
=======

import com.project.model.account.Account;

public interface IAccountService {
    Account saveAccount(Account account);
<<<<<<< HEAD
<<<<<<< HEAD
=======

    List<Account> findAllAccount();

    Account findByUsername(String username);


    void sendMail(String email, String username, String passwordResetToken);

    Account findById(Integer id);

    void save(Account account);
>>>>>>> 25b5aa6fad5671e6ad979ca4d7bde7f115716f31
=======
>>>>>>> 14a5abf94087479d86462c46f3e7e5fff1310c4b
>>>>>>> 503fa03357badf99ebaebfdca637bc0cf1c5b5c5
}
