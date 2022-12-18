package com.project.service.users;


import com.project.dto.user.UserTopDto;
import com.project.model.account.AccountRole;
import com.project.model.users.Address;
import com.project.model.users.User;
import org.springframework.stereotype.Service;
import com.project.model.account.Account;

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
     User findUserById(int id);

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find all user list
     *
     * @return List<User>
     */
     List<User> findAll();


    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find user
     *
     * @return List<User>
     */
     void updateUserByIdServer(User user);

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find user by id
     *
     * @return List<User>
     */
     Optional<User> findById(int id);

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
     * By: HaiNT - Find list of users by idList
     *
     * @return
     */
    List<User> findByIdList(List<Integer> id);

    void updateAddress(User user);



    void unlockUser(List<Integer> idList);

    User findUserByAccount(Account account);

    void updateUserById(User user);


//    void createAccountRole(AccountRole accountRole);
}

