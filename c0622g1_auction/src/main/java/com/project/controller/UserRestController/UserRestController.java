package com.project.controller.UserRestController;


import com.project.dto.user.UserDto;
import com.project.model.users.Address;
import com.project.model.users.User;

import com.project.service.users.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user/v1")
public class UserRestController {
    @Autowired
    private IUserService userService;

    @PostMapping("/create")
    public ResponseEntity<Void> addUser(@RequestBody UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
