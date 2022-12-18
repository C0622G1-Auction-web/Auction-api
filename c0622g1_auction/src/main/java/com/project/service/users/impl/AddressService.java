package com.project.service.users.impl;
import com.project.model.users.Address;
import com.project.repository.users.IAddressRepository;
import com.project.service.users.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private IAddressRepository addressRepository;

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create address
     * @return Address
     */
    @Override
    public Address createAddress(Address address) {
        return addressRepository.createAddress(
                address.getDetailAddress(),
                address.getTown(),
                address.getDistrict(),
                address.getCity(),
                address.getCountry());
    }

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to update address
     * @return Address
     */
    @Override
    public Address updateAddress(Address address) {
        return addressRepository.updateAddress(
                address.getDetailAddress(),
                address.getTown(),
                address.getDistrict(),
                address.getCity(),
                address.getCountry());
    }
    @Override
    public Address saveAddress(Address address) {
        addressRepository.save(address);
        return address;
    }

}
