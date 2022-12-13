package com.project.util;


import com.project.model.account.Account;
import com.project.model.account.PasswordResetToken;
import com.project.repository.account.IResetPassTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PasswordResetTokenUtil {
    private final int expiry = 60*24;

    @Autowired
    IResetPassTokenRepository resetPassTokenRepository;

    public PasswordResetToken createToken(Account account) {
        String token = UUID.randomUUID().toString();
        LocalDateTime expiryDate = LocalDateTime.now().plusMinutes(expiry);
        PasswordResetToken resetToken = new PasswordResetToken(token,expiryDate, false,account);
        resetPassTokenRepository.save(resetToken);
        return resetToken;


    }
}
