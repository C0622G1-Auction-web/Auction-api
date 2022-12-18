package com.project.service.users.impl;

import com.project.model.users.UserType;
import com.project.repository.users.IUserTypeRepository;
import com.project.service.users.IUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeService implements IUserTypeService {

    @Autowired
    private IUserTypeRepository userRepository;

    @Override
    public List<UserType> getAllUserTypes() {
        return userRepository.myFindAll();
    }
}
