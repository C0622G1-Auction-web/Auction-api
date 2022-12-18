package com.project.service.users.impl;

import com.project.dto.user.UserTopDto;
import com.project.model.account.Account;

import com.project.model.users.Address;
import com.project.model.users.User;
import com.project.repository.account.IAccountRepository;
import com.project.repository.users.IAddressRepository;
import com.project.repository.users.IUserRepository;
import com.project.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IAddressRepository addressRepository;
    @Autowired
    private IAccountRepository accountRepository;

   /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to update user
     *
     * @param user
     * @return User
     */

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(
                user.getAvatar(),
                user.getBirthDay(),
                user.getDeleteStatus(),
                user.getEmail(),
                user.getFirstName(),
                user.getIdCard(),
                user.getLastName(),
                user.getPhone(),
                user.getPointDedication(),
                user.getAccount(),
                user.getAddress(),
                user.getUserType(),
                user.getId());
    }

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find user by id
     * @param user
     * @return User
     */
    @Override
    public void updateUserById(User user) {
        userRepository.save(user);
    }

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find user by id
     *
     * @param user
     * @return User
     */
    @Override
    public void updateUserByIdServer(User user) {
        userRepository.save(user);
    }


    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find user by id
     *
     * @param user
     * @return User
     */
    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create user
     *
     * @return User
     */

    public void createUser(User user, Integer addressId, Integer accountId, Integer userType) {

    public void saveUser(User user, Integer addressId, Integer accountId,Integer userType) {
        userRepository.createUser(
                user.getAvatar(),
                user.getBirthDay(),
                user.getDeleteStatus(),
                user.getEmail(),
                user.getFirstName(),
                user.getIdCard(),
                user.getLastName(),
                user.getPhone(),
                user.getPointDedication(),
                accountId,
                addressId,
                userType);
    }

//    public void saveUser(User user, Integer addressId, Integer accountId, Integer userType) {
//        userRepository.createUser(
//                user.getAvatar(),
//                user.getBirthDay(),
//                user.getDeleteStatus(),
//                user.getEmail(),
//                user.getFirstName(),
//                user.getIdCard(),
//                user.getLastName(),
//                user.getPhone(),
//                user.getPointDedication(),
//                user.getAccount(),
//                user.getAddress(),
//                user.getUserType());
//    }

    /**
     * Create by: VietNQ
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find user by id
     *
     * @param id
     * @return User
     */

    @Override
    public User findUserById(int id) {
        return userRepository.findUserById(id).get();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

@Override
    public List<User> findAll() {
        return null;
    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     * Function: to lockAccount
     *
     * @param id
     */
    public void lockUser(List<Integer> id) {
        userRepository.lockAccount(id);
    }

    /* Create by: HaiNT
     * Date created: 13/12/2022
     * @param id
     * @param name
     * @param email
     * @param userTypeId
     * @param address
     * @return List of users by param
     */

    @Override
    public Page<User> getUserBy(String id, String name, String email, String userTypeId, String address, Pageable pageable) {
        return userRepository.getUserBy(id, name, email, userTypeId, address, pageable);
    }


    /**
     * Create by: DucDH
     * Date: 17/12/2022
     * Function: To get a User by email
     *
     * @Param: email
     * @return: User if email found, null otherwise
     */

//    @Override
//    public Optional<Address> findByAddressId(int id) {
//        return addressRepository.findById(id);
//    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param id
     * @return Object Account by id
     */
     
    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }


//    @Override
//    public Optional<User> findById(Integer id) {
//        return userRepository.findById(id);
//    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param
     * @return User object by id
     */

//    @Override
//    public void saveUser(User user, Integer addressId, Integer accountId, Integer Number) {
//    }

    public Optional<Account> findByAccountId(int id) {
        return accountRepository.findById(id);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param user
     */

    @Override
    public void updateAddressByRoleAdmin(User user) {
        userRepository.save(user);
    }

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     *
     * @param
     */
    @Override
    public Optional<User> findById(int id) {
       return userRepository.findUserById(id);
        return userRepository.findById(id);

    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void unlockUser(List<Integer> idList) {

    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param user
     */
    @Override
    public void updateUserByRoleAdmin(User user) {
        updateAddressByRoleAdmin(user);
        userRepository.updateUserByRoleAdmin(user.getId(), user.getIdCard(), user.getAvatar(), user.getBirthDay(), user.getEmail(),
                user.getFirstName(), user.getLastName(), user.getPhone());
    }


//    @Override
//      public void unlockUser(List<Integer> idList) {
//
//    }


    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param id
     * @return User object by id
     */

//    @Override
//    public List<User> findByIdList(List<Integer> id) {
//        return userRepository.findUserByIdList(id);
//    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param idList
     */
//    @Override
//    public void unlockUser(List<Integer> idList) {
//        userRepository.unlockAccount(idList);
//    }

    /**
     * Created: SangDD
     * Created date: 13/12/2022
     * Function: get Top 10 users with the highest total money auction
     *
     * @param quality user quality
     * @return List<User>
     */

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param id
     * @return User object by id
     */

    @Override
    public List<User> findByIdList(List<Integer> id) {
        return userRepository.findUserByIdList(id);
    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param idList
     */
     
//    @Override
//    public void unlockUser(List<Integer> idList) {
//        userRepository.unlockAccount(idList);
//    }
    @Override
    public void unlockAccountByIdList(List<Integer> idList) {
        userRepository.unlockAccountByIdList(idList);
    }

    /**
     * Created: SangDD
     * Created date: 13/12/2022
     * Function: get Top 10 users with the highest total money auction
     *
     * @param quality user quality
     * @return List<User>
     */

        /**
         * Create by: HaiNT
         * Date created: 13/12/2022
         *
         * @param id
         * @return User object by id
         */

    @Override
    public List<User> findByIdList(List<Integer> id) {
        return userRepository.findUserByIdList(id);
    }


    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param idList
     */
    @Override
    public void unlockUser(List<Integer> idList) {
        userRepository.unlockAccount(idList);
    }

    /**
     * Created: SangDD
     * Created date: 13/12/2022
     * Function: get Top 10 users with the highest total money auction
     *
     * @param quality user quality
     * @return List<User>
     */

    @Override
    public List<UserTopDto> getTopAuctionUser(String quality) {

        return userRepository.getTopAuctionUser(quality);
    }

    /**
     * Created by UyenNC
     * Date created 13/12/2022
     * Function Find user by account
     *
     * @param account
//    @Override
//    public List<UserTopDto> getTopAuctionUser(String quality) {
//
//        return userRepository.getTopAuctionUser(quality);
//    }

//    /**
//     * Created by UyenNC
//     * Date created 13/12/2022
//     * Function Find user by account
//     *
//     * @param account
//     * @return User
//     */
//
//    @Override
//    public User findUserByAccount(Account account) {
//        String id = account.getId() + "";
//        return userRepository.findUserByAccount(id);
//    }
    @Override
    public List<UserTopDto> getTopAuctionUser(String quality) {
        return userRepository.getTopAuctionUser(quality);
    }

    /**
     * Created by UyenNC
     * Date created 13/12/2022
     * Function Find user by account
     *
     * @param account
     * @return User
     */

    @Override

    public User findUserByAccount(Account account) {
        String id = account.getId() + "";
        return userRepository.findUserByAccount(id);
    }

    @Override
    public Optional<Address> findByAddressId(Integer id) {
        return addressRepository.findById(id);
    }

    @Override
    public void updateAddress(User user) {
        
    }

    @Override
    public Optional<Object> findById(int id) {
        return Optional.empty();
    }

    /**
     * Created: HungNV
     * Created date: 16/12/2022
     * Function: get Top 10 users with the highest total money auction
     *
     * @param id
     * @return User
     */

    @Override
    public User findUserByAccount(Account account) {
        String id = account.getId() + "";
        return userRepository.findUserByAccount(id);
    public User getUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}

