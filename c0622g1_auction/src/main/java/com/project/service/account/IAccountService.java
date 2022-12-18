package com.project.service.account;

import com.project.model.account.Account;

import java.util.List;

public interface IAccountService {

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create account
     *
     * @return Account
     */
    Account createAccount(Account account);

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to update account
     *
     * @return Account
     */
    Account updateAccount(Account account);

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find user by id
     *
     * @return Account
     */

    Account findByUserId(Integer id);

    /**
     * Created by: DucDH
     * Date created: 18/12/2022
     * Function: To find an account by username
     * @param username
     * @return Account if username found
     * Null if username not found
     */

    Account findAccountByUsername(String username);

    Account saveAccount(Account account);

    List<Account> findAllAccount();

    Account findByUsername(String username);

    void sendMail(String email, String username, String passwordResetToken);

    void save(Account account);

    Account findById(Integer id);

}
