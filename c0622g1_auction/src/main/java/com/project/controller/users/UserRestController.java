package com.project.controller.users;

<<<<<<< HEAD
<<<<<<< HEAD
import com.project.dto.user.UserCreateUpdateDto;
import com.project.dto.user.UserDto;
=======
import com.project.dto.UserListDto;
>>>>>>> b739c3f338c30618ded9c4a54577ffd7b4ea4f8c
=======
import com.project.dto.UserListDto;
=======
import com.project.dto.user.UserCreateUpdateDto;
import com.project.dto.user.UserDto;
>>>>>>> 85dec02c67d3f7e9a7374c9ce5721ba3e53f47ca
>>>>>>> 8a53852b3b92fb4dfc9ffe310dcaf37caf83d581
import com.project.dto.user.*;
import com.project.model.account.Account;
import com.project.model.users.Address;
import com.project.model.users.User;
import com.project.service.account.IAccountService;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.project.service.account.ILockAccountService;
import com.project.service.users.IAddressService;
import com.project.service.users.IUserService;
=======
>>>>>>> 8a53852b3b92fb4dfc9ffe310dcaf37caf83d581
import com.project.service.users.IAddressService;
import com.project.service.users.IUserService;
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
<<<<<<< HEAD
=======
import com.project.service.account.ILockAccountService;
import com.project.service.users.IAddressService;
import com.project.service.users.IUserService;
>>>>>>> b739c3f338c30618ded9c4a54577ffd7b4ea4f8c
=======
>>>>>>> 85dec02c67d3f7e9a7374c9ce5721ba3e53f47ca
>>>>>>> 8a53852b3b92fb4dfc9ffe310dcaf37caf83d581
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
<<<<<<< HEAD
<<<<<<< HEAD
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/users")
=======
>>>>>>> b739c3f338c30618ded9c4a54577ffd7b4ea4f8c
=======
=======
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/users")
>>>>>>> 85dec02c67d3f7e9a7374c9ce5721ba3e53f47ca
>>>>>>> 8a53852b3b92fb4dfc9ffe310dcaf37caf83d581
public class UserRestController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private ILockAccountService lockAccountService;

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create user
     *
     * @return HttpStatus.NOT_CONTENT, HttpStatus.NOT_MODIFIED
     */
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Validated @RequestBody UserCreateUpdateDto userCreateUpdateDto, BindingResult bindingResult) {
        List<User> userList = userService.findAll();
        List<String> emailList = new ArrayList<>();
        for (User item : userList) {
            emailList.add(item.getEmail());
            emailList.add(item.getAccount().getUsername());
        }
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.validate(userCreateUpdateDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NO_CONTENT);
        }
        User user = new User();
        Account account = new Account();
        BeanUtils.copyProperties(userCreateUpdateDto, account);
        Address address = new Address();
        BeanUtils.copyProperties(userCreateUpdateDto, address);
        Address address1 = addressService.createAddress(address);
        Account account1 = accountService.createAccount(account);
        BeanUtils.copyProperties(userCreateUpdateDto, user);
        user.setAccount(account1);
        user.setAddress(address1);
        user.setDeleteStatus(true);
        userService.createUser(user);
<<<<<<< HEAD
<<<<<<< HEAD
=======
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to update user by id
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
>>>>>>> 8a53852b3b92fb4dfc9ffe310dcaf37caf83d581
    private IAddressService addressService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserTypeService userTypeService;
    @Autowired
    private ILockAccountService lockAccountService;
<<<<<<< HEAD
=======
        return new ResponseEntity<>(HttpStatus.OK);
    }
>>>>>>> b739c3f338c30618ded9c4a54577ffd7b4ea4f8c
=======
>>>>>>> 85dec02c67d3f7e9a7374c9ce5721ba3e53f47ca
>>>>>>> 8a53852b3b92fb4dfc9ffe310dcaf37caf83d581

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
        return new ResponseEntity<>(HttpStatus.OK);
    }



    /**
<<<<<<< HEAD
<<<<<<< HEAD
=======
     * <<<<<<< HEAD
>>>>>>> b739c3f338c30618ded9c4a54577ffd7b4ea4f8c
=======
     * Create by: HaiNT
=======
>>>>>>> 8a53852b3b92fb4dfc9ffe310dcaf37caf83d581
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to update user by id
     *
     * @return HttpStatus.OK, HttpStatus.NOT_MODIFIED
     */
    @PutMapping("/{id}/update")
    public ResponseEntity<?> editUserById(@Validated @PathVariable() int id, @RequestBody UserCreateUpdateDto userCreateUpdateDto, BindingResult bindingResult) {
        List<User> userList = userService.findAll();
        List<String> emailList = new ArrayList<>();
        for (User item : userList) {
            emailList.add(item.getEmail());
            emailList.add(item.getAccount().getUsername());
        }
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.validate(userCreateUpdateDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        } else {
            User user = userService.findUserById(id).get();
            Account account = new Account();
            BeanUtils.copyProperties(userCreateUpdateDto, account);
            Address address = new Address();
            BeanUtils.copyProperties(userCreateUpdateDto, address);
            Address address1 = addressService.updateAddress(address);
            Account account1 = accountService.updateAccount(account);
            BeanUtils.copyProperties(userCreateUpdateDto, user);
            user.setAccount(account1);
            user.setAddress(address1);
            userService.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

<<<<<<< HEAD
<<<<<<< HEAD
     /** Create by: HaiNT
=======
    /**
     * Create by: HaiNT
>>>>>>> b739c3f338c30618ded9c4a54577ffd7b4ea4f8c
=======
     /** Create by: HaiNT
>>>>>>> 85dec02c67d3f7e9a7374c9ce5721ba3e53f47ca
>>>>>>> 8a53852b3b92fb4dfc9ffe310dcaf37caf83d581
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
     *
     * @return HttpStatus.NOT_FOUND if result is not empty
     */
    @PostMapping("/create")
    public ResponseEntity<?> addUser(@RequestBody AddUserDto addUserDto) {

        AddressDto addressDto = new AddressDto(addUserDto.getDetailAddress(), addUserDto.getTown(), addUserDto.getDistrict(), addUserDto.getCity(), addUserDto.getCountry());
        AccountDto accountDto = new AccountDto(addUserDto.getUsername(), addUserDto.getPassword());

        AddUserDto userDto1 = new AddUserDto(addUserDto.getFirstName(), addUserDto.getLastName(), addUserDto.getEmail(),
                addUserDto.getPhone(), addUserDto.getPointDedication(), addUserDto.getBirthDay(), addUserDto.getIdCard(), addUserDto.getAvatar(), addressDto, accountDto);

        User user = new User();
        Address address = new Address();
        Account account = new Account();

        BeanUtils.copyProperties(addressDto, address);
        BeanUtils.copyProperties(accountDto, account);
        BeanUtils.copyProperties(userDto1, user);

        Address addressATBC = addressService.saveAddress(address);
        Account accountABT = accountService.saveAccount(account);
        accountABT.setStatusLock(true);
        accountABT.setDeleteStatus(true);
        accountABT.setPassword("12345678");
        userService.saveUser(user, addressATBC.getId(), accountABT.getId(), 4);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
