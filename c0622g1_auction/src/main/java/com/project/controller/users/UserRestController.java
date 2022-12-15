package com.project.controller.users;

<<<<<<< HEAD
import com.project.dto.user.UserDto;
=======

import com.project.dto.user.*;
>>>>>>> 14a5abf94087479d86462c46f3e7e5fff1310c4b
import com.project.model.account.Account;
import com.project.model.users.Address;
import com.project.model.users.User;
import com.project.service.account.IAccountService;
<<<<<<< HEAD
import com.project.service.users.IAddressService;
import com.project.service.users.IUserService;
=======
import com.project.service.account.ILockAccountService;
import com.project.service.users.IAddressService;
import com.project.service.users.IUserService;


import com.project.dto.UserListDto;
import com.project.dto.user.UserTopDto;
import com.project.model.users.User;
import com.project.service.account.IAccountService;
import com.project.service.users.IAddressService;
import com.project.service.users.IUserService;
import com.project.service.users.IUserTypeService;

>>>>>>> 14a5abf94087479d86462c46f3e7e5fff1310c4b
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
=======
>>>>>>> 14a5abf94087479d86462c46f3e7e5fff1310c4b
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
@RestController
@CrossOrigin("*")
@RequestMapping("/api/user/v1")
=======
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/users")
>>>>>>> 14a5abf94087479d86462c46f3e7e5fff1310c4b
public class UserRestController {

    @Autowired
    private IUserService userService;

    @Autowired
<<<<<<< HEAD
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
        user.setDeleteStatus(true);
        userService.createUser(user);
=======
    private IAddressService addressService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserTypeService userTypeService;
    @Autowired
    private ILockAccountService lockAccountService;

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param id
     * @param name
     * @param email
     * @param address
     * @param userTypeId
     * @return List User by param if param is empty then return list all users
     */
    @GetMapping
    public ResponseEntity<List<UserListDto>> getAllUser(
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
        List<UserListDto> userListDtos = new ArrayList<>();
        for (User user : userList) {
            UserListDto userListDto = new UserListDto();
            BeanUtils.copyProperties(user, userListDto);
            userListDto.setId(user.getId());
            userListDtos.add(userListDto);
        }
        return new ResponseEntity<>(userListDtos, HttpStatus.OK);
    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
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
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param id
     * @param userListDto
     * @return the user object is updated
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserListDto> updateUser(@PathVariable() int id, @RequestBody UserListDto userListDto) {
        User user = userService.findById(id).get();
        BeanUtils.copyProperties(userListDto, user);
        userService.updateUser(user);
>>>>>>> 14a5abf94087479d86462c46f3e7e5fff1310c4b
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
<<<<<<< HEAD
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
            Account account1 = accountService.updateAccount(account);
            BeanUtils.copyProperties(userDto, user);
            user.setAccount(account1);
            user.setAddress(address1);
            userService.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
=======
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param idList
     * @return the user object is unlock
     */
    @PutMapping("/unlockUser")
    public ResponseEntity<UserListDto> unlockUser(@RequestBody List<Integer> idList) {
        List<User> userList = userService.findByIdList(idList);
        if (idList.size() != userList.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.unlockUser(idList);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Created: SangDD
     * Created date: 13/12/2022
     * Function: get Top 10 users with the highest total money auction
     *
     * @return HttpStatus.NOT_FOUND if result is not empty
     */
    @GetMapping("/top/{quality}")
    public ResponseEntity<List<UserTopDto>> getTopAuctionUser(@PathVariable String quality) {
        String regexNumber = "^\\d+$";
        if (!quality.matches(regexNumber)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<UserTopDto> userTopDtoList = userService.getTopAuctionUser(quality);
        if (userTopDtoList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userTopDtoList, HttpStatus.OK);
    }

    /**
     * Created: VietNQ
     * Created date: 13/12/2022
     * Function: create user account
     * @return HttpStatus.OK if result is not empty
     * @return HttpStatus.NOT_FOUND if result is not empty
     */
    @PostMapping("/create")
    public ResponseEntity<?> addUser(@RequestBody AddUserDto addUserDto) {

        AddressDto addressDto = new AddressDto(addUserDto.getDetailAddress(), addUserDto.getTown(), addUserDto.getDistrict(), addUserDto.getCity(), addUserDto.getCountry());
        AccountDto accountDto = new AccountDto(addUserDto.getUsername(), addUserDto.getPassword());

        UserDto userDto = new UserDto(addUserDto.getFirstName(), addUserDto.getLastName(), addUserDto.getEmail(),
                addUserDto.getPhone(), addUserDto.getPointDedication(), addUserDto.getBirthDay(), addUserDto.getIdCard(), addUserDto.getAvatar(), addressDto, accountDto);

        User user = new User();
        Address address = new Address();
        Account account = new Account();

        BeanUtils.copyProperties(addressDto, address);
        BeanUtils.copyProperties(accountDto, account);
        BeanUtils.copyProperties(userDto, user);

        Address addressATBC = addressService.saveAddress(address);
        Account accountABT = accountService.saveAccount(account);
        accountABT.setStatusLock(true);
        accountABT.setDeleteStatus(true);
        accountABT.setPassword("12345678");
        userService.saveUser(user, addressATBC.getId(), accountABT.getId(), 4);

        return new ResponseEntity<>(HttpStatus.OK);
    }

>>>>>>> 14a5abf94087479d86462c46f3e7e5fff1310c4b
}
