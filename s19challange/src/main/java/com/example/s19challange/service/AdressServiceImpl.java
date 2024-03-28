package com.example.s19challange.service;

import com.example.s19challange.dto.AddressResponseDto;
import com.example.s19challange.dto.UserResponseDto;
import com.example.s19challange.entity.Address;
import com.example.s19challange.entity.User;
import com.example.s19challange.repository.AddressesRepository;
import com.example.s19challange.util.AddressDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdressServiceImpl implements AddressService{

    private AddressesRepository addressesRepository;

    private UserService userService;

    @Autowired
    public AdressServiceImpl(AddressesRepository addressesRepository, UserService userService) {
        this.addressesRepository = addressesRepository;
        this.userService = userService;
    }

    @Override
    public AddressResponseDto save(Address address, Long userId) {
//         1- Find "User" with using "userId
        User user = userService.findByIdOriginal(userId);
//         2-
        user.addAdresses(address);
        address.setUser(user);
        //TODO Make Dto here
        addressesRepository.save(address);
        return new AddressResponseDto(address.getStreet(), address.getCity(), address.getZipCode(),
                new UserResponseDto(user.getFullName(), user.getEmail()));

    }

    @Override
    public List<AddressResponseDto> findAll() {
        //TODO Make return AddressDto
        // TODO You need to make
        List<Address> addresses = addressesRepository.findAll();
        return AddressDtoConvertion.convertAddressList(addresses);
    }

    @Override
    public Address findByOriginal(Long id) {
        Optional<Address> addressOptional = addressesRepository.findById(id);
        if (addressOptional.isPresent()){
            return addressOptional.get();
        }
        //TODO Make Exception here
        return null;
    }

    @Override
    public AddressResponseDto findById(Long id) {
        Optional<Address> addressOptional = addressesRepository.findById(id);
        if (addressOptional.isPresent()){
            //TODO Make Convert Here
            Address address = addressOptional.get();
            return AddressDtoConvertion.convertAdress(address);
        }
        //TODO Make Exeption here
        return null;
    }

    @Override
    public List<AddressResponseDto> findAddressesByName(String name) {
        //TODO Make AddressListDto here
        List<Address> addressesResponse = addressesRepository.findAddressByName(name);
        return AddressDtoConvertion.convertAddressList(addressesResponse);
    }

    @Override
    public AddressResponseDto delete(Long id) {

        //TODO Make Dto Here
        AddressResponseDto addressResponse = findById(id);
        if (addressResponse != null){
            addressesRepository.deleteById(id);
            return addressResponse;
        }
        return null;
    }


}
