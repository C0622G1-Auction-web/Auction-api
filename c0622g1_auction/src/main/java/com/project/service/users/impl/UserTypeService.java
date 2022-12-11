package com.project.service.users.impl;

import com.project.repository.users.IUserTypeRepository;
import com.project.service.users.IUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeService implements IUserTypeService {
    @Autowired
    private IUserTypeRepository userRepository;
}
