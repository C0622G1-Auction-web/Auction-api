package com.project.service.account.impl;

import com.project.model.account.Account;
import com.project.repository.account.IAccountRepository;
import com.project.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    JavaMailSender javaMailSender;

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create account
     *
     * @return Account
     */

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to update account
     *
     * @return Account
     */

    @Override
    public Account updateAccount(Account account) {
        return accountRepository.updateAccount(
                account.getUsername(),
                account.getPassword());
    }


    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    /**
     * Created by UyenNC
     * Date created 13/12/2022
     * Function: Find all valid account
     *
     * @return List<Account>
     **/
    @Override
    public List<Account> findAllAccount() {
        return accountRepository.findAllAccount();
    }

    /**
     * Created by UyenNC
     * Date created 13/12/2022
     * Function: Find account by username
     *
     * @param username
     * @return Account
     */
    @Override
    public Account findByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    /**
     * Created by UyenNC
     * Date created 13/12/2022
     * Function Send mail with reset link to user's email
     *
     * @param email
     * @param username
     * @param passwordResetToken
     */
    @Override
    public void sendMail(String email, String username, String passwordResetToken, Integer accountId) throws MessagingException, MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setSubject("Cấp lại mật khẩu");
        mimeMessageHelper.setTo(email);
        String url = "http://localhost:4200/account/reset_password?token=" + passwordResetToken + "&account=" + accountId;
        String text = "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Message</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1 style=\"color: #0088ff\">Email Đặt Lại Mật Khẩu</h1>\n" +
                "<p>Xin chào,</p>\n" +
                "<p>Đây là email hỗ trợ lấy lại mật khẩu đến từ Đấu giá C06,\n" +
                "    <br>Để đặt lại mật khẩu mới cho tài khoản của mình, vui lòng nhấn vào link bên dưới\n" +
                "    <br>" + url + "</p>\n" +
                "<p>Nếu có thắc mắc hoặc cần hỗ trợ, vui lòng liên hệ số hotline: <strong style=\"color: orangered\">0909.999.999</strong><br>\n" +
                "Trân trọng,<br>\n" +
                "Nhóm hỗ trợ trang web Đấu giá C06.</p>\n" +
                "<img width=\"150px\" height=\"150px\" src=\"https://drive.google.com/uc?export=view&id=11H2qQuq8cktTZcMQqVPRk3QgeLSTgXCr\">\n" +
                "</body>\n" +
                "</html>";
        mimeMessageHelper.setText(text, true);
        javaMailSender.send(mimeMessage);
    }

    /**
     * Created by UyenNC
     * Date created 13/12/2022
     * Function Find account by account id
     *
     * @param id
     * @return Account
     */
    @Override
    public Account findById(Integer id) {
        return accountRepository.findAccountById(id);
    }

    /**
     * Created by UyenNC
     * Date created 13/12/2022
     * Function Update password for given account
     *
     * @param account
     */
    @Override
    public void save(Account account) {
        Integer accountId = account.getId();
        String password = account.getPassword();
        accountRepository.updateAccount(accountId, password);
    }

    @Override
    public Account findByUserId(Integer id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public Account findLockById(Integer id) {
        return accountRepository.findLockAccountById(id);
    }

}
