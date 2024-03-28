package com.example.s19challange.util;

import com.example.s19challange.dto.AddressResponseDto;
import com.example.s19challange.dto.UserResponseDto;
import com.example.s19challange.entity.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressDtoConvertion {

    public static List<AddressResponseDto> convertAddressList(List<Address> addresses){
        List<AddressResponseDto> addressResponses = new ArrayList<>();
        addresses.stream().forEach(address ->
                addressResponses.add(new AddressResponseDto(address.getStreet(), address.getCity(),
                        address.getZipCode(),new UserResponseDto(address.getUser().getFullName(),
                        address.getUser().getEmail()))));
        return addressResponses;
    }

    public static AddressResponseDto convertAdress(Address address){
        return new AddressResponseDto(address.getStreet(), address.getCity(), address.getZipCode(),
                new UserResponseDto(address.getUser().getFullName(),address.getUser().getEmail()));
    }
}
