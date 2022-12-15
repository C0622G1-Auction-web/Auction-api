package com.project.service.users;

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

}
