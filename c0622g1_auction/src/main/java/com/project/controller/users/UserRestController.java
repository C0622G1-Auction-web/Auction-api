package com.project.controller.users;


import com.project.dto.UserListDto;
import com.project.dto.user.*;
import com.project.model.account.Account;
import com.project.model.users.Address;
import com.project.model.users.User;
import com.project.model.users.UserType;
import com.project.service.account.IAccountService;
import com.project.service.users.IAddressService;
import com.project.service.users.IUserService;
<<<<<<< HEAD


import com.project.dto.user.UserListDto;
import com.project.dto.user.UserTopDto;
=======
>>>>>>> b529c2b05fbb822ab7b98de68978be70b2e4f8a4
import com.project.service.users.IUserTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    @GetMapping("/list")
    public ResponseEntity<List<UserListDto>> getAllUser(
            @RequestParam(required = false, defaultValue = "") String id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String email,
            @RequestParam(required = false, defaultValue = "") String address,
            @RequestParam(required = false, defaultValue = "") String userTypeId,
            @PageableDefault(value = 3) Pageable pageable) {
        Page<User> userList = userService.getUserBy(id, name, email, userTypeId, address, pageable);
        if (userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<UserListDto> userListDtos = new ArrayList<>();
        for (User user : userList) {
            UserListDto userListDto = new UserListDto();
            BeanUtils.copyProperties(user, userListDto);
            userListDto.setAccount(user.getAccount());
            userListDto.setAddress(user.getAddress());
            userListDto.setUserType(user.getUserType());
            userListDto.setId(user.getId());
            userListDtos.add(userListDto);
        }
        return new ResponseEntity<>(userListDtos, HttpStatus.OK);
    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     * @param id
     * @return Object user by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> userById(@PathVariable() int id) {
        User user = userService.findById(id).orElse(null);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

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
     * @return HttpStatus.NOT_FOUND if result is not empty
     */
    @PostMapping("/add")
    public ResponseEntity<?> addUser( @Validated @RequestBody FormAddUser formAddUser) {

       AddressDto addressDto= new AddressDto(formAddUser.getDetailAddress(),formAddUser.getTown(),formAddUser.getDistrict(),formAddUser.getCity(),formAddUser.getCountry());
        AccountDto accountDto = new AccountDto(formAddUser.getUsername(), formAddUser.getPassword(),formAddUser.getStatusLock(),formAddUser.getDeleteStatus());
        AddUserDto addUserDto = new AddUserDto(formAddUser.getFirstName(), formAddUser.getLastName(), formAddUser.getEmail(),
                formAddUser.getPhone(), formAddUser.getPointDedication(), formAddUser.getBirthDay(),
                formAddUser.getIdCard(), formAddUser.getAvatar(), addressDto, accountDto);

        User user = new User();
        Address address = new Address();
        Account account = new Account();

        BeanUtils.copyProperties(addressDto, address);
        BeanUtils.copyProperties(accountDto, account);
        BeanUtils.copyProperties(addUserDto, user);

        Address addressATBC = addressService.saveAddress(address);
        Account accountABT = accountService.saveAccount(account);

        userService.saveUser(user, addressATBC.getId(), accountABT.getId(), 4);

        return new ResponseEntity<>(HttpStatus.OK);
    }

<<<<<<< HEAD

=======
    /**
     * Create by: VietNQ
     * Date created: 13/12/2022
     *Function: to lockAccount
     * @param id
     * @return HttpStatus.OK if result is not empty
     * @return HttpStatus.NOT_FOUND if result is not empty
     */
    @PutMapping("/lockUser")
    public ResponseEntity<UserListDto> lockUser(@RequestBody List<Integer> id) {
        List<User> userList = userService.findByIdList(id);
        if (id.size() != userList.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.lockUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
>>>>>>> b529c2b05fbb822ab7b98de68978be70b2e4f8a4
}
