package com.project.service.users.impl;

import com.project.model.users.User;
import com.project.dto.user.UserTopDto;
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
    public void saveUser(User user, Integer addressId, Integer accountId,Integer userType) {
        userRepository.createUser(
                user.getAvatar(),
                user.getBirthDay(),
                user.getDeleteStatus(),
                user.getEmail(),
                user.getFirstName(),
                user.getIdCard(),
                user.getLastName(),
                user.getPhone(),
                user.getPointDedication(),
                accountId,
                addressId,
                userType);

    }

    /**
     * Created: SangDD
     * Created date: 13/12/2022
     * Function: get Top 10 users with the highest total money auction
     * @param quality user quality
     * @return List<User>
     */
    @Override
    public List<UserTopDto> getTopAuctionUser(String quality) {

        return userRepository.getTopAuctionUser(quality);
    }
}
