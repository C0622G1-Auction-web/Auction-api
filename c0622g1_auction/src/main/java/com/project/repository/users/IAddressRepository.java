package com.project.repository.users;

import com.project.model.account.Account;
import com.project.model.users.Address;
import com.project.model.users.User;
import com.project.model.users.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IAddressRepository extends JpaRepository<Address, Integer> {
    @Modifying
    @Query(value = "insert into " +
            "address(" +
            "detail_address," +
            "town," +
            "district," +
            "city," +
            "coutry)",
            nativeQuery = true)
    void  createAddress(@RequestParam("detail_address") String detail_address,
                     @RequestParam("town") String town,
                     @RequestParam("district") String district,
                     @RequestParam("city") String city,
                     @RequestParam("coutry") String coutry);
}
