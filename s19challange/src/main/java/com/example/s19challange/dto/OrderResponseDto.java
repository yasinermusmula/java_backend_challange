package com.example.s19challange.dto;

import com.example.s19challange.entity.Order;

import java.util.List;

public record OrderResponseDto(Integer orderNuber, Double amount,
                               AddressResponseDto address) {
}
