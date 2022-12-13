package com.project.repository.users;


import com.project.model.users.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {
    @Modifying
    @Query(value = "insert into address(id, detail_address, town, district, city, country)" +
            "values(" +
            ":id," +
            ":detailAddress," +
            ":town," +
            ":district," +
            ":city," +
            ":country)",
            nativeQuery = true)
    void saveAddress(
            @Param("id") Integer id,
            @Param("detailAddress") String detailAddress,
            @Param("town") String town,
            @Param("district") String district,
            @Param("city") String city,
            @Param("country") String country);
}
