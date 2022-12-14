package com.project.service.users;


import com.project.dto.user.UserTopDto;
import com.project.model.users.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IUserService {
    void saveUser(User user, Integer addressId, Integer accountId, Integer Number);


        /**
         * Created: SangDD
         * Created date: 13/12/2022
         * Function: get Top 10 users with the highest total money auction
         *
         * @param quality user quality
         * @return List<User>
         */
        List<UserTopDto> getTopAuctionUser(String quality);
    }
