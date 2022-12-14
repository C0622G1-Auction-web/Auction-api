package com.project.repository.account;


import com.project.model.account.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IResetPassTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
    /**
     * Created by UyenNC
     * Date created 13/12/2022
     * Function Find PasswordResetToken by token
     *
     * @param token
     * @return PasswordResetToken
     */
    @Query(value = "select* from password_reset_token where token =:token and status = 0;", nativeQuery = true)
    PasswordResetToken findByToken(@Param(value = "token") String token);


    /**Created by UyenNC
     * Date created 13/12/2022
     * Function Save new token to database
     * @param token
     * @param expiry
     * @param status
     * @param accountId
     */
    @Query(value = "insert into `password_reset_token` (`expiry_date`, `status`, `token`, `account_id`) " +
            "values (:expiry, :status, :token, :accountId);", nativeQuery = true)
    void createToken(@Param("token") String token, @Param("expiry") String expiry, @Param("status") Boolean status, @Param("accountId") String accountId);
}
