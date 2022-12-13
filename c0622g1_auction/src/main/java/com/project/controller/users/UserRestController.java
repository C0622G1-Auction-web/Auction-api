package com.project.controller.users;

import com.project.dto.user.UserDto;
import com.project.model.users.User;
import com.project.service.users.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user/v1")
public class UserRestController {
    @Autowired
    private IUserService userService;

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create user
     * @return UHttpStatus.NOT_MODIFIED
     * @return UHttpStatus.OK
     */
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Validated @RequestBody UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }
        User user= new User();
        BeanUtils.copyProperties(userDto,user);
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create user
     * @return UHttpStatus.OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(userService.findUserById(id).get(), HttpStatus.OK);
    }

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create user
     * @return UHttpStatus.OK
     */
    @PutMapping("/edit")
    public ResponseEntity<?> editUserById(@Validated @RequestBody UserDto userDto,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }
        else{
            User user= new User();
            BeanUtils.copyProperties(userDto,user);
            userService.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
