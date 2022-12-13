package com.project.repository.users;

import com.project.model.account.Account;
import com.project.model.users.Address;
import com.project.model.users.User;
import com.project.model.users.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User,Integer> {

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find by id
     * @param id
     * @return Optional<User>
     */

    @Query(value = "select * " +
            "from user u " +
            "where u.id= :id " +
            "and u.delete_status=1",
            nativeQuery = true)
    Optional<User> findUserById(@Param("id") int id);

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create user
     * @param avatar,
     * @param birthDay,
     * @param deleteStatus,
     * @param email,
     * @param fistName,
     * @param idCard,
     * @param lastName,
     * @param phone,
     * @param pointDedication,
     * @param accountId,
     * @param addressId,
     * @param userTypeId
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
            " values(:avatar," +
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
                    @Param("accountId") Account accountId,
                    @Param("addressId") Address addressId,
                    @Param("userTypeId") UserType userTypeId);

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to update user
     * @param avatar,
     * @param birthDay,
     * @param deleteStatus,
     * @param email,
     * @param fistName,
     * @param idCard,
     * @param lastName,
     * @param phone,
     * @param pointDedication,
     * @param accountId,
     * @param addressId,
     * @param userTypeId
     * @param id
     */

    @Modifying
    @Query(value = " update `user` " +
            "set `avatar` = :avatar , " +
            " `birth_day` = :birthDay ," +
            " `delete_status` = :deleteStatus , " +
            " `email` = :email ," +
            " `first_name` = :fistName , " +
            " `id_card` = :idCard ," +
            " `last_name` = :lastName, " +
            " `phone` = :phone, " +
            " `point_dedication` = :pointDedication, " +
            " `account_id` = :accountId, " +
            " `address_id` = :addressId, " +
            " `user_type_id` = :userTypeId, " +
            "where (`id` = :id) ", nativeQuery = true)
    void updateUser(@Param("avatar") String avatar,
                    @Param("birthDay") String birthDay,
                    @Param("deleteStatus") Boolean deleteStatus,
                    @Param("email") String email,
                    @Param("fistName") String fistName,
                    @Param("idCard") String idCard,
                    @Param("lastName") String lastName,
                    @Param("phone") String phone,
                    @Param("pointDedication") Double pointDedication,
                    @Param("accountId") Account accountId,
                    @Param("addressId") Address addressId,
                    @Param("userTypeId") UserType userTypeId,
                    @Param("id") Integer id);

}
