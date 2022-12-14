package com.project.service.account;

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
}
