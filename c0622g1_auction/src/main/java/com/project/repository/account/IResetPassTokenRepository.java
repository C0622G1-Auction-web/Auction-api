package com.project.repository.account;


import com.project.model.account.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResetPassTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
}
