package com.project.controller.users;


import com.project.dto.user.*;
import com.project.model.account.Account;
import com.project.model.users.Address;
import com.project.model.users.User;
import com.project.service.account.IAccountService;
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

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/users")
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
