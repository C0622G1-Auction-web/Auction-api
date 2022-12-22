package com.project.repository.account;

import com.project.model.account.LockAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ILockAccountRepository extends JpaRepository<LockAccount, Integer> {

    /**
     * By: VietNQ
     *
     * @param id
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE lock_account SET start_day= :start_day, end_day= :end_day, reason= :reason,`status_lock` = 0 WHERE (`id` = :id);", nativeQuery = true)
    void lockAccount(@Param("id") Integer id);

    /**
     * Created by: VietNQ
     * */
    @Transactional
    @Modifying
    @Query(value = "insert into  lock_account (start_day, end_day, reason, account_id)"+
            " values(:startDay," +
            ":endDay," +
            ":reason," +
            ":accountId)",
            nativeQuery = true)
    void createLockUser(@Param("startDay") String startDay,
                        @Param("endDay") String endDay,
                        @Param("reason") String reason,
                        @Param("accountId") Integer accountId);
}
