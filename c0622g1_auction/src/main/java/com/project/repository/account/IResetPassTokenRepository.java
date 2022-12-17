package com.project.repository.account;


import com.project.model.account.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

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
     * @param accountId
     */
    @Modifying
    @Query(value = "insert into password_reset_token (expiry_date, status, token, account_id) " +
            "values (:expiry, 0, :token, :accountId )", nativeQuery = true)
    @Transactional
    void createToken( @Param("expiry") String expiry,
                      @Param("token") String token,
                      @Param("accountId") String accountId);

    /**Created by UyenNC
     * Date created 15/12/2022
     * Function Find all token of a given account id
     * @param accountId
     * @return
     */
    @Query(value = "select* from password_reset_token where account_id =:accountId and status = 0;", nativeQuery = true)
    List<PasswordResetToken> findTokenByAccountId(String accountId);
}
