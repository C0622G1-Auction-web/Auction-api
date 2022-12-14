package com.project.controller.users;

import com.project.dto.user.UserDto;
import com.project.model.account.Account;
import com.project.model.users.Address;
import com.project.model.users.User;
import com.project.service.account.IAccountService;
import com.project.service.users.IAddressService;
import com.project.service.users.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user/v1")
public class UserRestController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IAddressService addressService;

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create user
     *
     * @return HttpStatus.NOT_CONTENT, HttpStatus.NOT_MODIFIED
     */
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Validated @RequestBody UserDto userDto, BindingResult bindingResult) {
        List<User> userList = userService.findAll();
        List<String> emailList = new ArrayList<>();
        for (User item : userList) {
            emailList.add(item.getEmail());
            emailList.add(item.getAccount().getUsername());
        }
        userDto.setEmailList(emailList);
        userDto.validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NO_CONTENT);
        }
        User user = new User();
        Account account = new Account();
        BeanUtils.copyProperties(userDto, account);
        Address address = new Address();
        BeanUtils.copyProperties(userDto, address);
        Address address1 = addressService.createAddress(address);
        Account account1 = accountService.createAccount(account);
        BeanUtils.copyProperties(userDto, user);
        user.setAccount(account1);
        user.setAddress(address1);
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to update user by id
     *
     * @return HttpStatus.OK, HttpStatus.NOT_MODIFIED
     */
    @PutMapping("/{id}/update")
    public ResponseEntity<?> editUserById(@Validated @PathVariable() int id, @RequestBody UserDto userDto, BindingResult bindingResult) {
        List<User> userList = userService.findAll();
        List<String> emailList = new ArrayList<>();
        for (User item : userList) {
            emailList.add(item.getEmail());
            emailList.add(item.getAccount().getUsername());
        }
        userDto.setEmailList(emailList);
        userDto.validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        } else {
            User user = userService.findUserById(id).get();
            Account account = new Account();
            BeanUtils.copyProperties(userDto, account);
            Address address = new Address();
            BeanUtils.copyProperties(userDto, address);
            Address address1 = addressService.updateAddress(address);
            Account account1 = accountService.updateAddress(account);
            BeanUtils.copyProperties(userDto, user);
            user.setAccount(account1);
            user.setAddress(address1);
            userService.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
