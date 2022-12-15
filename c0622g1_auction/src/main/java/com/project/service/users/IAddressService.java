package com.project.service.users;


import com.project.model.users.Address;
import org.springframework.stereotype.Service;

@Service
public interface IAddressService {
    Address saveAddress(Address address);
}
