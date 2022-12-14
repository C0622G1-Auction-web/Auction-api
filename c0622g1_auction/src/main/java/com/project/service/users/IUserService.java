package com.project.service.users;


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

}
