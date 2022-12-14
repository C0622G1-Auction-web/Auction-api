package com.project.repository.users;


import com.project.dto.user.UserTopDto;
import com.project.model.users.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {
    /**
     * Create by: VietNQ
     * Date created: 13/12/2022
     * Function: to create user
     * @return HttpStatus.NotFound
     * @return HttpStatus.OK
     */
    @Modifying
    @Query(value = "insert into " +
            "user(avatar," +
            "birth_day," +
            "delete_status," +
            "email," +
            "first_name," +
            "id_card," +
            "last_name," +
            "phone," +
            "point_dedication," +
            "account_id," +
            "address_id," +
            "user_type_id)" +
            " values (" +
            ":avatar," +
            ":birthDay," +
            ":deleteStatus," +
            ":email," +
            ":fistName," +
            ":idCard," +
            ":lastName," +
            ":phone," +
            ":pointDedication," +
            ":accountId," +
            ":addressId," +
            ":userTypeId)",
            nativeQuery = true)
    void createUser(@Param("avatar") String avatar,
                    @Param("birthDay") String birthDay,
                    @Param("deleteStatus") Boolean deleteStatus,
                    @Param("email") String email,
                    @Param("fistName") String fistName,
                    @Param("idCard") String idCard,
                    @Param("lastName") String lastName,
                    @Param("phone") String phone,
                    @Param("pointDedication") Double pointDedication,
                    @Param("accountId") Integer accountId,
                    @Param("addressId") Integer addressId,
                    @Param("userTypeId") Integer userTypeId);


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
