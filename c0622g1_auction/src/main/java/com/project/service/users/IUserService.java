package com.project.service.users;


import com.project.dto.user.UserTopDto;

import java.util.List;

public interface IUserService {
    /**
     * Created: SangDD
     * Created date: 13/12/2022
     * Function: get Top 10 users with the highest total money auction
     * @param quality user quality
     * @return List<User>
     */
    List<UserTopDto> getTopAuctionUser(String quality);
}
