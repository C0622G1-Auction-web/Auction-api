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
                    @Param("accountId") Account accountId,
                    @Param("addressId") Address addressId,
                    @Param("userTypeId") UserType userTypeId);

    @Modifying
    @Query(value = "insert into address(id, detail_address, town, district, city, country)" +
            "values(" +
            ":id," +
            ":detailAddress," +
            ":town," +
            ":district," +
            ":city," +
            ":country)",
            nativeQuery = true)
    void saveAddress(
            @Param("id") Integer id,
            @Param("detailAddress") String detailAddress,
            @Param("town") String town,
            @Param("district") String district,
            @Param("city") String city,
            @Param("country") String country);
}
