package com.project.service.users.impl;

import com.project.dto.IUserDto;
import com.project.repository.users.IUserRepository;
import com.project.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public IUserDto findIdUser(Integer id) {
        return userRepository.findIdUser(id);
    }
}
