package com.project.util;

import com.project.model.account.Account;
import com.project.model.account.PasswordResetToken;
import com.project.repository.account.IResetPassTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
public class PasswordResetTokenUtil {
    private final int expiry = 60 * 24;

    @Autowired
    IResetPassTokenRepository resetPassTokenRepository;

    /**
     * Created by UyenNC
     * Date created 13/12/2022
     * Function Find PasswordResetToken by token
     *
     * @param token
     * @return PasswordResetToken
     */
    public PasswordResetToken validateToken(String token) {
        PasswordResetToken passwordResetToken = resetPassTokenRepository.findByToken(token);
        return passwordResetToken;

    }

    /**
     * Created by UyenNC
     * Date created 13/12/2022
     * Function Create new token, save token to database
     *
     * @param account
     * @return PasswordResetToken
     */
    public PasswordResetToken createToken(Account account) {
        String token = UUID.randomUUID().toString();
        LocalDateTime expiryDate = LocalDateTime.now().plusMinutes(expiry);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String expiry = expiryDate.format(format);
        String accountId = account.getId() + "";
        PasswordResetToken resetToken = new PasswordResetToken(token, expiry, false, account);
        resetPassTokenRepository.createToken(expiry, token, accountId);
        return resetToken;
    }

    /**Created by UyenNC
     * Date created 15/12/2022
     * Function Validate whether the token belongs to the account or not
     * @param accountId
     * @param token
     * @return
     */
    public PasswordResetToken validateTokenByAccountId(String accountId, String token) {
        List<PasswordResetToken> tokenList = resetPassTokenRepository.findTokenByAccountId(accountId);
        for (int i = 0; i < tokenList.size(); i++) {
            if (tokenList.get(i).getToken().equals(token)) {
                return tokenList.get(i);
            }
        }
        return null;
    }
}
