package com.project.controller.account;

import com.project.model.account.Account;
import com.project.model.account.PasswordResetToken;
import com.project.model.users.User;
import com.project.service.account.IAccountService;
import com.project.service.users.IUserService;
import com.project.util.PasswordResetTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/account")
public class AccountRestController {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private PasswordResetTokenUtil passwordResetTokenUtil;

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public ResponseEntity<List<Account>> showAccountList(){
        List<Account> accountList = accountService.findAllAccount();
        if(accountList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    @GetMapping("verify_account")
    public ResponseEntity<String> verifyAccount(@RequestParam(value = "email") String email, @RequestParam(value = "username") String username){
        Account account = accountService.findByUsername(username);

        if(account == null){
            return new ResponseEntity<>("Không tìm thấy tài khoản, vui lòng kiểm tra lại", HttpStatus.NOT_FOUND);
        }
        User user = userService.findUserByAccount(account);


        if(user.getEmail().equals(email)){
            PasswordResetToken passwordResetToken = passwordResetTokenUtil.createToken(account);
            accountService.sendMail(email,username, passwordResetToken.getToken());
            return new ResponseEntity<>("Tài khoản hợp lệ, vui lòng kiểm tra hòm thư gmail", HttpStatus.OK);
        }


        return new ResponseEntity<>("Email không hợp lệ, vui lòng kiểm tra lại", HttpStatus.NOT_FOUND);

    }
}
