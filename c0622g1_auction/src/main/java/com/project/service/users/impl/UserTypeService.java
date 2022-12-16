package com.project.service.users.impl;

<<<<<<< HEAD
import com.project.model.users.UserType;
import com.project.repository.users.IUserTypeRepository;
=======
>>>>>>> b529c2b05fbb822ab7b98de68978be70b2e4f8a4
import com.project.service.users.IUserTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeService implements IUserTypeService {
<<<<<<< HEAD
    @Autowired
    private IUserTypeRepository userRepository;

    @Override
    public List<UserType> getAllUserTypes() {
        return userRepository.myFindAll();
    }
=======
>>>>>>> b529c2b05fbb822ab7b98de68978be70b2e4f8a4
}
