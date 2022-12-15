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

<<<<<<< HEAD
<<<<<<< HEAD
=======
    Address saveAddress(Address address);
>>>>>>> b739c3f338c30618ded9c4a54577ffd7b4ea4f8c
=======
    Address saveAddress(Address address);
=======
>>>>>>> 85dec02c67d3f7e9a7374c9ce5721ba3e53f47ca
>>>>>>> 8a53852b3b92fb4dfc9ffe310dcaf37caf83d581
}
