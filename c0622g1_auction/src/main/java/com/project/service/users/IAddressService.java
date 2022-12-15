package com.project.service.users;

<<<<<<< HEAD
import com.project.model.users.Address;

public interface IAddressService {
    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create address
     * @return HttpStatus.OK
     */
    Address createAddress(Address address);

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: update address
     * @return Address
     */
    Address updateAddress(Address address);
=======

import com.project.model.users.Address;


public interface IAddressService {
    Address saveAddress(Address address);
>>>>>>> 14a5abf94087479d86462c46f3e7e5fff1310c4b
}
