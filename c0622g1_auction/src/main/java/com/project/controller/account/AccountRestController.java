package com.project.controller.account;

import com.project.model.account.Account;
import com.project.model.account.PasswordResetToken;
import com.project.model.users.User;
import com.project.service.account.IAccountService;
import com.project.service.users.IUserService;
import com.project.util.PasswordResetTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountRestController {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private PasswordResetTokenUtil passwordResetTokenUtil;

    @Autowired
    private IUserService userService;

    /**
     * Created by UyenNC
     * Date created: 13/12/2022
     * Function: Show Account List
     *
     * @return List<Account> + HttpStatus.OK
     * @return HttpStatus.NO_CONTENT
     */
    @GetMapping("")
    public ResponseEntity<List<Account>> showAccountList() {
        List<Account> accountList = accountService.findAllAccount();
        if (accountList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    /**
     * Created by UyenNC
     * Date created: 13/12/2022
     * Function: Check whether the account and email is valid. If the account and email are valid, reset password link will be sent via the email
     *
     * @param email
     * @param username
     * @return "Không tìm thấy tài khoản, vui lòng kiểm tra lại" + HttpStatus.NOT_FOUND
     * "Tài khoản hợp lệ, vui lòng kiểm tra hòm thư gmail"+ HttpStatus.OK
     * "Email không hợp lệ, vui lòng kiểm tra lại" + HttpStatus.NOT_FOUND
     */
    @GetMapping("verify_account")
    public ResponseEntity<String> verifyAccount(@RequestParam(value = "email") String email, @RequestParam(value = "username") String username) {
        Account account = accountService.findByUsername(username);
        String message;
        if (account == null) {
            message = "Không tìm thấy tài khoản, vui lòng kiểm tra lại";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        User user = userService.findUserByAccount(account);


        if (user.getEmail().equals(email)) {
            PasswordResetToken passwordResetToken = passwordResetTokenUtil.createToken(account);
            accountService.sendMail(email, username, passwordResetToken.getToken(), account.getId());
            message = "Tài khoản hợp lệ, vui lòng kiểm tra hòm thư gmail";
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        message = "Email không hợp lệ, vui lòng kiểm tra lại";

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    /***Created by UyenNC
     * Date created: 13/12/2022
     * Function: Check whether the token attached to the link is valid and not expired. If it is valid and not expired, redirect to the update password link
     * @param token
     * @return "Token không tồn tại" + HttpStatus.NOT_FOUND
     *  "Token đã hết hạn"+ HttpStatus.GATEWAY_TIMEOUT
     *  headers + HttpStatus.MOVED_PERMANENTLY
     */
    @GetMapping("token_check")
    public ResponseEntity<String> checkToken(@RequestParam(value = "token") String token) {
        PasswordResetToken passwordResetToken = passwordResetTokenUtil.validateToken(token);
        if (passwordResetToken == null) {
            return new ResponseEntity<>("Token không tồn tại", HttpStatus.NOT_FOUND);
        }
        String date = passwordResetToken.getExpiryDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime expiryDate = LocalDateTime.parse(date, formatter);
        if (expiryDate.isBefore(LocalDateTime.now())) {
            return new ResponseEntity<>("Token đã hết hạn", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Token hợp lệ", HttpStatus.OK);
    }

    /***Created by UyenNC
     * Date created: 13/12/2022
     * Function: Update new password
     * @param password
     * @param accountId
     * @return "Cập nhật mật khẩu thành công" + HttpStatus.OK
     */

    @GetMapping("update_pass")
    public ResponseEntity<?> updatePassword(@RequestParam(value = "id", required = false) String accountId,
                                            @RequestParam(value = "token", required = false) String token,
                                            @RequestParam(value = "password", required = false) String password) {
        Account account = accountService.findById(Integer.valueOf(accountId));

        if (account == null) {
            return new ResponseEntity<>("Tài khoản không tồn tại", HttpStatus.NOT_FOUND);
        }

        PasswordResetToken passwordResetToken = passwordResetTokenUtil.validateTokenByAccountId(String.valueOf(account.getId()), token);
        if (passwordResetToken == null) {
            return new ResponseEntity<>("Token không đúng", HttpStatus.NOT_FOUND);
        }

        String date = passwordResetToken.getExpiryDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime expiryDate = LocalDateTime.parse(date, formatter);
        if (expiryDate.isBefore(LocalDateTime.now())) {
            return new ResponseEntity<>("Token đã hết hạn", HttpStatus.BAD_REQUEST);
        }
        if (password == null) {
            return new ResponseEntity<>("Password không được null", HttpStatus.BAD_REQUEST);
        }
        if (password.trim().length() == 0 || password.length() == 0) {
            return new ResponseEntity<>("Password không được để trống", HttpStatus.BAD_REQUEST);
        }
        if (password.length() < 5 || password.length() > 50) {
            return new ResponseEntity<>("Password có độ dài tối thiểu là 5 kí tự và tối đa là 50 kí tự", HttpStatus.BAD_REQUEST);
        }

//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encryptPass = passwordEncoder.encode(password);
//        account.setPassword(encryptPass);
        accountService.save(account);
        return new ResponseEntity<>("Cập nhật mật khẩu thành công", HttpStatus.OK);
    }
}

