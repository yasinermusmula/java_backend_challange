package com.example.s19challange.service;

import com.example.s19challange.dto.AddressResponseDto;
import com.example.s19challange.entity.Address;

import java.util.List;

public interface AddressService {
    AddressResponseDto save(Address address, Long userId);

    List<AddressResponseDto> findAll();

    Address findByOriginal(Long id);

    AddressResponseDto findById(Long id);

    List<AddressResponseDto> findAddressesByName(String name);

    AddressResponseDto delete(Long id);
}
