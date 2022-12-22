package com.project.service.account;

import com.project.model.account.Account;

import javax.mail.MessagingException;
import java.util.List;
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

    Account saveAccount(Account account);

    List<Account> findAllAccount();

    Account findByUsername(String username);


    void sendMail(String email, String username, String passwordResetToken, Integer accountId) throws MessagingException;

    Account findById(Integer id);

    void save(Account account);


    Account findByUserId(Integer id);

    Account findLockById(Integer accountId);
}
