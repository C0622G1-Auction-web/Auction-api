package com.project.service.account.impl;

import com.project.model.account.Account;
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
    JavaMailSender javaMailSender;
    @Autowired
    IAccountRepository accountRepository;
    @Override
    public List<Account> findAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    @Override
    public void sendMail(String email, String username, String passwordResetToken) {
        String message = "Xin chào "+username+","+"\nVui lòng bấm vào link để đặt lại mật khẩu: \n";
        String url = "http://localhost:8080/api/v1/token_check?token="+passwordResetToken;
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("Cấp lại mật khẩu");
        mailMessage.setText(message + url);
        mailMessage.setTo(email);
        javaMailSender.send(mailMessage);
    }

}
