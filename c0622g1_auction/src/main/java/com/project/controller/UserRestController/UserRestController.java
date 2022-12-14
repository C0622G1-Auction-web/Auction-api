package com.project.controller.UserRestController;


import com.project.dto.user.*;

import com.project.model.account.Account;
import com.project.model.account.LockAccount;
import com.project.model.users.Address;
import com.project.model.users.User;
import com.project.service.account.IAccountService;
import com.project.service.account.ILockAccountService;
import com.project.service.users.IAddressService;
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
    @Autowired
    private IAddressService addressService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private ILockAccountService lockAccountService;


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

}
