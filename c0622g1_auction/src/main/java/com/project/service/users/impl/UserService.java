package com.project.service.users.impl;

import com.project.model.users.User;
import com.project.repository.users.IUserRepository;
import com.project.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getUserBy(String id, String name, String email, String userTypeId, String address) {
        return userRepository.getUserBy(id, name, email, userTypeId, address);
    }

    @Override
    public User findById(int id) {
        return userRepository.findUserById(id).orElse(null);
    }

}
