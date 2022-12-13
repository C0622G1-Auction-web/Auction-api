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
@RequestMapping("/api/useraaaaa")
public class UserRestController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserTypeService userTypeService;

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


    @GetMapping("/{id}")
    public ResponseEntity<User> userById(@PathVariable() int id) {
        User quanLyVe = userService.findById(id);
        if (quanLyVe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quanLyVe, HttpStatus.OK);
    }



}
