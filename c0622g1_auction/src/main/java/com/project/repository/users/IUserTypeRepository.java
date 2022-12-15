package com.project.repository.users;

import com.project.model.users.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface IUserTypeRepository extends JpaRepository<UserType, Integer> {
}
