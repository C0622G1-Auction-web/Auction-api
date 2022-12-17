package com.project.controller.security;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.project.model.account.Account;
import com.project.model.account.Role;
import com.project.model.users.User;
import com.project.payload.request.LoginForm;
import com.project.payload.request.TokenDto;
import com.project.payload.respone.JwtRespone;
import com.project.payload.respone.MessageRespone;
import com.project.security.jwt.JwtProvider;
import com.project.security.user_detail.MyUserDetail;
import com.project.service.account.IAccountService;
import com.project.service.role.IRoleService;
import com.project.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/auth")
public class SecurityController {

    @Value("${google.client-id}")
    private String googleClientId;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

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

        return new ResponseEntity<>(new JwtRespone(token,
                myUserDetail.getAuthorities(),
                myUserDetail.getAccount(),
                myUserDetail.getAccount().getUser()), HttpStatus.OK);
    }


    /**
     * Created by DucDH,
     * Date Created: 17/12/2022
     * Function: to Authenticate a LoginForm and return to the server a Token
     *
     * @param tokenDto
     * @return ResponseEntity that contains an instance of JwtRespone and HttpStatus.200_OK if successful
     *         ResponseEntity that contains HttpStatus.NO_CONTENT if nothing happens
     */

    @PostMapping("/google")
    public ResponseEntity<?> loginWithGoogle(@RequestBody TokenDto tokenDto) throws IOException {

        final NetHttpTransport transport = new NetHttpTransport();
        final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();

        GoogleIdTokenVerifier.Builder verifier = new GoogleIdTokenVerifier.Builder(transport, jacksonFactory)
                .setAudience(Collections.singletonList(googleClientId));

        final GoogleIdToken googleIdToken = GoogleIdToken.parse(verifier.getJsonFactory(), tokenDto.getValue());
        final GoogleIdToken.Payload payload = googleIdToken.getPayload();

        String email = payload.getEmail();

        User user = userService.getUserByEmail(email);

        JwtRespone jwtRespone = new JwtRespone();

        if (user == null || user.getAccount() == null) {

            jwtRespone.setEmail(email);

            return new ResponseEntity<>(jwtRespone, HttpStatus.OK);
        }

        Account account = user.getAccount();
        if (account != null) {
            jwtRespone.setAccount(account);
            jwtRespone.setUser(user);

            List<Role> roles = roleService.getListRoleByAccountId(account.getId());
            List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

            for (Role x : roles) {
                grantedAuthorityList.add(new SimpleGrantedAuthority(x.getName()));
            }

            jwtRespone.setRoles(grantedAuthorityList);
            jwtRespone.setToken(jwtProvider.createTokenWithUsername(account.getUsername()));

            return new ResponseEntity<>(jwtRespone, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
