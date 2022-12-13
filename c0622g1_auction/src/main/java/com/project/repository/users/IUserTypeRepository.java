package com.project.repository.users;

import com.project.model.users.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IUserTypeRepository extends JpaRepository<UserType, Integer> {
    @Query(value = "select * from project.user_type", nativeQuery = true)
    List<UserType> findAllUserTyper();
}
