package com.project.service.account.impl;

import com.project.model.account.Account;

import com.project.model.account.AccountRole;
import com.project.repository.account.IAccountRepository;
import com.project.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    JavaMailSender javaMailSender;


    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }


    /**Created by UyenNC
     * Date created 13/12/2022
     * Function: Find all valid account
     * @return List<Account>
     *
     **/
    @Override
    public List<Account> findAllAccount() {
        return accountRepository.findAllAccount();
    }

    /**Created by UyenNC
     * Date created 13/12/2022
     * Function: Find account by username
     * @param username
     * @return Account
     */
    @Override
    public Account findByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    /**Created by UyenNC
     * Date created 13/12/2022
     * Function Send mail with reset link to user's email
     * @param email
     * @param username
     * @param passwordResetToken
     */
    @Override
    public void sendMail(String email, String username, String passwordResetToken) {
        String message = "Xin chào " + username + "," + "\nVui lòng bấm vào link để đặt lại mật khẩu: \n";
        String url = "http://localhost:8080/api/v1/account/token_check?token=" + passwordResetToken;
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("Cấp lại mật khẩu");
        mailMessage.setText(message + url);
        mailMessage.setTo(email);
        javaMailSender.send(mailMessage);
    }

    /**Created by UyenNC
     * Date created 13/12/2022
     * Function Find account by account id
     * @param id
     * @return Account
     */
    @Override
    public Account findById(Integer id) {
        return accountRepository.findAccountById(id);
    }

    /**Created by UyenNC
     * Date created 13/12/2022
     * Function Update password for given account
     * @param account
     */
    @Override
    public void save(Account account) {
        Integer accountId = account.getId();
        String password = account.getPassword();
        accountRepository.updateAccount(accountId, password);
    }

}
