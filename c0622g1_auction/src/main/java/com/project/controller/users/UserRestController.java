package com.project.controller.users;

import com.project.dto.user.*;
import com.project.model.account.Account;
import com.project.model.account.LockAccount;
import com.project.model.users.Address;
import com.project.model.users.User;
import com.project.model.users.UserType;
import com.project.service.account.IAccountService;
import com.project.service.account.ILockAccountService;
import com.project.service.role.IAccountRoleService;
import com.project.service.users.IAddressService;
import com.project.service.users.IUserService;


import com.project.dto.user.UserListDto;
import com.project.dto.user.UserTopDto;
import com.project.service.users.IUserTypeService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@RestController
@CrossOrigin("*")
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
    @Autowired
    private ILockAccountService lockAccountService;

    @Autowired
    private IAccountRoleService accountRoleService;


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
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param id
     * @param name
     * @param email
     * @param address
     * @param userType
     * @return List User by param if param is empty then return list all users
     */

    @GetMapping("/list")
    public ResponseEntity<Page<UserListDto>> getAllUser1(
            @RequestParam(required = false, defaultValue = "") String id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String email,
            @RequestParam(required = false, defaultValue = "") String address,
            @RequestParam(required = false, defaultValue = "") String userType,
            @PageableDefault(value = 3) Pageable pageable) {
        Page<User> userPage = userService.getUserBy(id, name, email, userType, address, pageable);

        if (userPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Page<UserListDto> auctionDtoPageByProductId = userPage.map(new Function<User, UserListDto>() {
            @Override
            public UserListDto apply(User user) {
                UserListDto userListDto = new UserListDto();
                BeanUtils.copyProperties(user, userListDto);
                userListDto.setAccount(user.getAccount());
                userListDto.setAddress(user.getAddress());
                userListDto.setUserType(user.getUserType());
                userListDto.setId(user.getId());
                return userListDto;
            }
        });
        return new ResponseEntity<>(auctionDtoPageByProductId, HttpStatus.OK);
    }

    /**
     * Create by: HungNV
     * Date created: 16/12/2022
     *
     * @param id
     * @return Object user by id
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<User> findUserById(@PathVariable() int id) {
        User user = userService.getUser(id);
        if (user == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param id
     * @return Object user by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> userById(@PathVariable() Integer id) {
        User user = userService.findById(id).orElse(null);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @return Object user by id
     */
    @GetMapping("/usersType")
    public ResponseEntity<List<UserType>> getAllUserTypes() {
        List<UserType> userTypes = userTypeService.getAllUserTypes();
        if (userTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userTypes, HttpStatus.OK);
    }


    /**
     * <<<<<<< HEAD
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
        userService.unlockAccountByIdList(idList);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param id
     * @param userEditDto
     * @return the user object is updated
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserListDto> updateUserByRoleAdmin(@PathVariable() Integer id, @RequestBody UserEditDto userEditDto) {
        User user = userService.findById(id).get();
        Address address = userService.findByAddressId(user.getAddress().getId()).get();
        Account account = userService.findByAccountId(user.getAccount().getId()).get();
        BeanUtils.copyProperties(userEditDto, address);
        BeanUtils.copyProperties(userEditDto, account);
        BeanUtils.copyProperties(userEditDto, user);
        userService.updateUserByRoleAdmin(user);
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
     * @return HttpStatus.OK if result is not empty
     * @return HttpStatus.NOT_FOUND if result is not empty
     */
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody FormAddUser formAddUser) {

        AddressDto addressDto = new AddressDto(formAddUser.getDetailAddress(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AccountDto accountDto = new AccountDto(formAddUser.getEmail(), formAddUser.getPassword(), formAddUser.getStatusLock(), formAddUser.getDeleteStatus());
        AddUserDto addUserDto = new AddUserDto(formAddUser.getFirstName(), formAddUser.getLastName(), formAddUser.getEmail(),
                formAddUser.getPhone(), formAddUser.getPointDedication(), formAddUser.getBirthDay(),
                formAddUser.getIdCard(), formAddUser.getDeleteStatus(), formAddUser.getAvatar(), addressDto, accountDto);

        User user = new User();
        Address address = new Address();
        Account account = new Account();

        BeanUtils.copyProperties(addressDto, address);
        BeanUtils.copyProperties(accountDto, account);
        BeanUtils.copyProperties(addUserDto, user);

        Address addressATBC = addressService.saveAddress(address);
        Account accountABT = accountService.saveAccount(account);

        userService.saveAddUser(user, addressATBC.getId(), accountABT.getId(), 5);
        accountRoleService.createAccountRole(accountABT.getId(), 2);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: VietNQ
     * Date created: 13/12/2022
     * Function: to lockAccount
     *
     * @param lockAccountDto
     * @return HttpStatus.OK if result is not empty
     * @return HttpStatus.NOT_FOUND if result is not empty
     */
    @PutMapping("/lockUser")
    public ResponseEntity<UserListDto> lockUser(@RequestBody LockAccountDto lockAccountDto) {
        userService.lockUser(lockAccountDto.getAccountId());
        Account accountIsLock = accountService.findLockById(lockAccountDto.getAccountId());
        LockAccount lockAccount = new LockAccount();
        BeanUtils.copyProperties(lockAccountDto, lockAccount);
        lockAccount.setAccount(accountIsLock);
        lockAccountService.addLockUser(lockAccount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

