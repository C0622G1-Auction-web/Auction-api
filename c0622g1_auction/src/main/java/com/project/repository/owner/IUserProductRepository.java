package com.project.repository.owner;

import com.project.model.owner.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IUserProductRepository extends JpaRepository<UserProduct,Integer> {
}
