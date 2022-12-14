package com.project.repository.users;

import com.project.dto.user.UserTopDto;
import com.project.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User,Integer> {


    /**
     * Created: SangDD
     * Created date: 13/12/2022
     * Function: get Top 10 users with the highest total money auction
     * @return List<User>
     */
    @Query(value = "SELECT " +
            "user.first_name, " +
            "user.last_name, " +
            "sum(a.current_price) as total_money_auction, " +
            "user.avatar, " +
            "user.email " +
            "FROM user " +
            "    RIGHT JOIN auction a on user.id = a.user_id\n" +
            "    RIGHT JOIN  payment p on a.id = p.auction_id\n" +
            "WHERE a.pay_status = 1 " +
            "    AND user.delete_status = 0 " +
            "GROUP By user.id " +
            "ORDER BY total_money_auction DESC " +
            "LIMIT :quality " ,
            nativeQuery = true)
    List<UserTopDto> getTopAuctionUser(@Param("quality") String quality);
}
