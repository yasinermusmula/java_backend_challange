package com.example.s19challange.service;

import com.example.s19challange.dto.OrderResponseDto;
import com.example.s19challange.entity.Order;

import java.util.List;

public interface OrderService {

    OrderResponseDto save(Order order, Long addressId, Long userId);

    OrderResponseDto update(Order order, Long orderId);

    List<OrderResponseDto> findAllOrders();

    Order findByOriginal(Long id);

    OrderResponseDto findById(Long id);

    OrderResponseDto delete(Long id);

    List<OrderResponseDto> getByPriceDesc();

    List<OrderResponseDto> getByPriceAsc();
}
