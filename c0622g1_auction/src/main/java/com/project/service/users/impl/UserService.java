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


    /**
     * Create by: VietNQ
     * Date created: 13/12/2022
     * Function: to create user
     *
     * @return void
     */
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void saveUser(User user, Integer addressId, Integer accountId, Integer userType) {
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
     * Create by: VietNQ
     * Date created: 13/12/2022
     *Function: to lockAccount
     * @param id
     */

    public void unlockUser(List<Integer> id) {
        userRepository.findUserByIdList(id);
    }
    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param id
     * @return User object by id
     */
    @Override
    public List<User> findByIdList(List<Integer> id) {
        return userRepository.findUserByIdList(id);
    }


    /**
     * Created: SangDD
     * Created date: 13/12/2022
     * Function: get Top 10 users with the highest total money auction
     *
     * @param quality user quality
     * @return List<User>
     */
    @Override
    public List<UserTopDto> getTopAuctionUser(String quality) {

        return userRepository.getTopAuctionUser(quality);
    }
}
