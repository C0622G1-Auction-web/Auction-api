package com.project.controller.security;

import com.project.model.account.Account;
import com.project.payload.request.LoginForm;
import com.project.payload.respone.JwtRespone;
import com.project.payload.respone.MessageRespone;
import com.project.security.jwt.JwtProvider;
import com.project.security.user_detail.MyUserDetail;
import com.project.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class SecurityController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * Created by DucDH,
     * Date Created: 13/12/2022
     * Function: to Authenticate a LoginForm and return to the server a Token
     *
     * @param loginForm
     * @return ResponseEntity that contains an instance of JwtRespone and HttpStatus.200_OK if successful
     */

    @PostMapping("/login")
    public ResponseEntity<?> login(@Validated @RequestBody LoginForm loginForm,
                                   BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_ACCEPTABLE);
        }

        Account accountValidate = accountService.findAccountByUsername(loginForm.getUsername());

        if (accountValidate == null) {
            return new ResponseEntity<>(new MessageRespone("username not found"), HttpStatus.NOT_FOUND);
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));

        MyUserDetail myUserDetail = (MyUserDetail) authentication.getPrincipal();

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.createToken(authentication);

        return new ResponseEntity<>(new JwtRespone(token, myUserDetail.getUsername(),
                myUserDetail.getAuthorities()), HttpStatus.OK);
    }


//    hello worrld
    //    hello worrld2

}
