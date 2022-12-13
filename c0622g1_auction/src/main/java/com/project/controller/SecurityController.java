package com.project.controller;

import com.project.payload.request.LoginForm;
import com.project.payload.respone.JwtRespone;
import com.project.security.jwt.JwtProvider;
import com.project.security.user_detail.MyUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class SecurityController {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * Created by DucDH,
     * Date Created: 13/12/2022
     * Function: to Authenticate a LoginForm and return to the server a Token
     * @param loginForm
     * @return HttpStatus.401_Unauthorized if username or password invalid or both.
     */

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm loginForm) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));

        MyUserDetail myUserDetail = (MyUserDetail) authentication.getPrincipal();

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.createToken(authentication);

        return ResponseEntity.ok(new JwtRespone(token, myUserDetail.getUsername(),
                myUserDetail.getAuthorities()));
    }

}
