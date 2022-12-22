package com.project.controller.users;

import com.project.dto.user.*;
import com.project.model.account.Account;
import com.project.model.account.LockAccount;
import com.project.model.users.Address;
import com.project.model.users.User;
import com.project.model.users.UserType;
import com.project.service.account.IAccountService;
import com.project.service.account.ILockAccountService;
import com.project.service.account_role.IAccountRoleService;
import com.project.service.users.IAddressService;
import com.project.service.users.IUserService;
import com.project.service.users.IUserTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IAccountRoleService accountRoleService;


    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create user
     *
     * @return HttpStatus.NOT_CONTENT, HttpStatus.OK
     */

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        User user = new User();
        Account account = new Account();
        BeanUtils.copyProperties(userDto, account);

        Address address = new Address();
        BeanUtils.copyProperties(userDto, address);

        BeanUtils.copyProperties(userDto,userService);
        Address address1 = addressService.createAddress(address);
        account.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Account account1 = accountService.createAccount(account);

        BeanUtils.copyProperties(userDto, user);

        user.setAccount(account1);
        user.setAddress(address1);
        user.setDeleteStatus(false);


        userService.createUser(user);
        accountRoleService.createAccountRole(user.getAccount().getId(), 2);
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
            @PageableDefault(value = 5) Pageable pageable){
        Page<User> userPage = userService.getUserBy(id, name, email, userType, address, pageable);
        if (userPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
    public ResponseEntity<?> findUserById(@PathVariable() int id) {
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
     * @return list user type
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
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param idList
     * @return the user object is unlock
     */

    @PostMapping("/unlockUser")
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

//    @GetMapping("/top")
//    public ResponseEntity<List<UserTopDto>> getTopAuctionUser() {
//        List<UserTopDto> userTopDtoList = userService.getTopAuctionUser();
//        if (userTopDtoList.size() == 0) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(userTopDtoList, HttpStatus.OK);
//    }
    @GetMapping("/top")
    public ResponseEntity<List<User>> getTopAuctionUser() {
        List<User> userTopDtoList = userService.getTopAuctionUser();
        if (userTopDtoList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userTopDtoList, HttpStatus.OK);
    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     * Function: to find product by list id
     *
     * @param idList
     * @return HttpStatus.NO_CONTENT if exists any product not found/  HttpStatus.OK and products found
     */
    @PostMapping("/find-by-list-id")
    public ResponseEntity<List<UserUnlockDto>> findByListId(@RequestBody List<Integer> idList) {
        if (idList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<UserUnlockDto> productDeleteDtos = userService.findByListId(idList);
        if (idList.size() != productDeleteDtos.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productDeleteDtos, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> findAll() {
        List<User> userList= userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     *
     * @param
     * @return all user
     */
    @GetMapping("/findAll")
    public ResponseEntity<?> userFindAll() {
        List<User> userList =userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to update user by id
     *
     * @return HttpStatus.OK, HttpStatus.NOT_MODIFIED
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> editUserById(@PathVariable() int id, @RequestBody UserDto userDto) {
        User user = userService.findUserById(id);
        Integer userId = user.getId();
        Address address = addressService.findAddressById(user.getAddress().getId());
        Integer addressId = user.getAddress().getId();
        Account account = accountService.findByUserId(user.getAccount().getId());
        Integer accountId = user.getAccount().getId();
        BeanUtils.copyProperties(userDto, account);
        BeanUtils.copyProperties(userDto, address);
        BeanUtils.copyProperties(userDto, user);
        account.setId(accountId);
        account.setPassword(passwordEncoder.encode(userDto.getPassword()));
        address.setId(addressId);
        user.setId(userId);
        user.setAccount(account);
        user.setAddress(address);
        user.setDeleteStatus(false);
        userService.updateUserByIdServer(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     *
     * @param
     * @return Object user by id
     */

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> userByIdServer(@PathVariable() int id) {
        User user = userService.findById(id).get();
        return new ResponseEntity<>(user, HttpStatus.OK);
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
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody FormAddUser formAddUser) {

        AddressDto addressDto = new AddressDto(formAddUser.getDetailAddress(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AccountDto accountDto = new AccountDto(formAddUser.getUsername(), formAddUser.getPassword(), formAddUser.getStatusLock(), formAddUser.getDeleteStatus());
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

        userService.saveAddUser(user, addressATBC.getId(), accountABT.getId(), 3);
        accountRoleService.createAccountRole(accountABT.getId(), 2);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
