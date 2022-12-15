package com.project.service.users;

import com.project.dto.user.UserTopDto;
import com.project.model.users.Address;
import com.project.model.users.User;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.project.model.account.Account;
import com.project.model.users.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to update user
     * @return User
     */

    void updateUser(User user);

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create user
     * @return User
     */

    void createUser(User user);

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find user by id
     * @param id
     * @return User
     */

    Optional<User> findUserById(int id);

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find all user list
     * @return List<User>
     */
    List<User> findAll();
=======
import java.util.List;
import java.util.Optional;


@Service
public interface IUserService {

    void saveUser(User user, Integer addressId, Integer accountId, Integer Number);


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
     * By: HaiNT - Find list of users by param
     */
    List<User> getUserBy(String id, String name, String email, String userTypeId, String address);

    /**
     * By: HaiNT - Find list of users by id
     *
     * @param id
     */
    Optional<User> findById(Integer id);

    /**
     * By: HaiNT - Find list of users by idList
     *
     * @return
     */
    List<User> findByIdList(List<Integer> id);

    /**
     * By: HaiNT - Find list of address by AddressId
     */
    Optional<Address> findByAddressId(int id);

    void updateAddress(User user);

    void updateUser(User user);

    void unlockUser(List<Integer> idList);

>>>>>>> 14a5abf94087479d86462c46f3e7e5fff1310c4b

}

