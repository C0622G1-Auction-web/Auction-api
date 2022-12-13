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
}
