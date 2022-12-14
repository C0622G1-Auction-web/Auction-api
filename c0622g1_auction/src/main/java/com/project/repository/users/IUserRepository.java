package com.project.repository.users;

import com.project.dto.IUserDto;
import com.project.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User,Integer> {
    @Query(value =  " select address.city, address.country, address.detail_address as detailAddress,address.district,address.town ," +
                    "user.email, user.first_name as firstName,user.last_name as lastName,user.phone,payment.shipping_description as shippingDescription " +
                    "from user " +
                    " join address on address.id = user.address_id " +
                    " join auction on auction.user_id = user.id " +
                    " join payment on payment.auction_id = auction.id " +
                    " where user.id = :id ",nativeQuery = true)
    IUserDto findIdUser(@Param("id") Integer id);

}
