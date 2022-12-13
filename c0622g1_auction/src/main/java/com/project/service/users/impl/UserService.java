package com.project.service.users.impl;

import com.project.model.account.Account;
import com.project.model.users.User;
import com.project.repository.users.IUserRepository;
import com.project.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;

    /**Created by UyenNC
     * Date created 13/12/2022
     * Function Find user by account
     * @param account
     * @return User
     */
    @Override
    public User findUserByAccount(Account account) {
        String id = account.getId() +"";
        return userRepository.findUserByAccount(id);
    }
}
