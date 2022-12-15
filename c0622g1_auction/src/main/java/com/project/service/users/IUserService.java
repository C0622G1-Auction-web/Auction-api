package com.project.service.users;


import com.project.dto.user.UserTopDto;
import com.project.model.users.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IUserService {

    /**
     * Create by: VietNQ
     * Date created: 13/12/2022
     * Function: to create user
     * @return void
     */
    void saveUser(User user, Integer addressId, Integer accountId, Integer Number);

    /**
     * Create by: VietNQ
     * Date created: 13/12/2022
     *Function: to lockAccount
     * @param id
     */
    void unlockUser(List<Integer> id);


    /**
     * By: HaiNT - Find list of users by idList
     * @return
     */
    List<User> findByIdList(List<Integer> id);



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
