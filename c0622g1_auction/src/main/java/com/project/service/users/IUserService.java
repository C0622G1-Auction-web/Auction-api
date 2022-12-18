package com.project.service.users;

import com.project.dto.user.UserTopDto;
import com.project.dto.user.UserUnlockDto;
import com.project.model.product.PriceStep;
import com.project.model.account.Account;
import com.project.model.users.Address;
import com.project.model.users.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.project.model.account.Account;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;


import java.util.List;
import java.util.Optional;


@Service

public interface IUserService {


    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to update user
     *
     * @return User
     */

    void updateUser(User user);

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create user
     *
     * @return User
     */

    void createUser(User user);

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find user by id
     *
     * @param id
     * @return User
     */

    Optional<User> findUserById(int id);

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find all user list
     *
     * @return List<User>
     */
    List<User> findAll();

    /**
     * By: HaiNT - Find list of users by param
     */
    Page<User> getUserBy(String id, String name, String email, String userType, String address, Pageable pageable);


    /**
     * By: HaiNT - Find list of users by idList
     *
     * @return
     */
    List<User> findByIdList(List<Integer> id);


    /**
     * By: HaiNT - Find list of address by AddressId
     */
    Optional<Account> findByAccountId(int id);

      /**
     * By: HaiNT - Find list of address by AddressId
     */
    Optional<Address> findByAddressId(int id);


    /**
     * By: HaiNT - Find list of address by AddressId
     */
    void updateAddressByRoleAdmin(User user);

    /**
     * By: HaiNT - Find list of address by AddressId
     */
    void updateUserByRoleAdmin(User user);

    /**
     * By: HaiNT - Find list of address by AddressId
     */
    void unlockAccountByIdList(List<Integer> idList);

    /**
     * By: HaiNT - Find list of users by id
     *
     * @param id
     */
    Optional<User> findById(Integer id);

    /**
     * By: HaiNT - Find list of users by id
     *
     * @param idList
     */
    List<UserUnlockDto> findByListId(List<Integer> idList);


    /**
     * Created: SangDD
     * Created date: 13/12/2022
     * Function: get Top 10 users with the highest total money auction
     *
     * @param quality user quality
     * @return List<User>
     */
    List<UserTopDto> getTopAuctionUser(String quality);


    /**
     * By: HungNV - Find user id
     */
    User getUser(Integer id);



    void lockUser(List<Integer> id);

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * @Param: int ID of User
     * Function: get User
     */
    User findUserByAccount(Account account);

}

