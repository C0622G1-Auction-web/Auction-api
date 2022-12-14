package com.project.controller.users;

import com.project.dto.UserDto;
import com.project.model.users.User;
import com.project.service.account.IAccountService;
import com.project.service.users.IAddressService;
import com.project.service.users.IUserService;
import com.project.service.users.IUserTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserTypeService userTypeService;

    /**
     * By: HaiNT
     *
     * @param id
     * @param name
     * @param email
     * @param address
     * @param userTypeId
     * @return List User by param if param is empty then return list all users
     */
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(
            @RequestParam(defaultValue = "") String id,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String email,
            @RequestParam(defaultValue = "") String address,
            @RequestParam(defaultValue = "") String userTypeId
    ) {
        List<User> userList = userService.getUserBy(id, name, email, userTypeId, address);
        if (userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<UserDto> userListDtos = new ArrayList<>();
        for (User user : userList) {
            UserDto userListDto = new UserDto();
            BeanUtils.copyProperties(user, userListDto);
            userListDto.setId(user.getId());
            userListDtos.add(userListDto);
        }
        return new ResponseEntity<>(userListDtos, HttpStatus.OK);
    }

    /**
     * By: HaiNT
     *
     * @param id
     * @return Object user by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> userById(@PathVariable() int id) {
        User user = userService.findById(id).get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * By: HaiNT
     *
     * @param id
     * @param userDto
     * @return the user object is updated
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable() int id, @RequestBody UserDto userDto) {
        User user = userService.findById(id).get();
        BeanUtils.copyProperties(userDto, user);
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * By: HaiNT
     * @param id
     * @return  the user object is unlock
     */
    @PutMapping("account/{id}")
    public ResponseEntity<UserDto> unlockUser(@PathVariable() int id) {
        User user = userService.findById(id).get();
        userService.unlockUser(user.getAccount().getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
