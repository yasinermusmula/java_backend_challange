package com.example.s19challange.dto;

public record AddressResponseDto(String street, String city,Integer zipCode,
                                 UserResponseDto user) {
}
