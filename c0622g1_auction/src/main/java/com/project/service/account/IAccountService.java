package com.project.service.account;

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
>>>>>>> 14a5abf94087479d86462c46f3e7e5fff1310c4b
}
