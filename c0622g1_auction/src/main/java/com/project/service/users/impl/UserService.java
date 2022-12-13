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

    @Override
    public User findUserByAccount(Account account) {
        return userRepository.findUserByAccount(account);
    }
}
