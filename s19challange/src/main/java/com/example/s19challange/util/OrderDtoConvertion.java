package com.example.s19challange.util;

import com.example.s19challange.dto.*;
import com.example.s19challange.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDtoConvertion {

    public static List<OrderResponseDto> convertAddressList(List<Order> orders){
        List<OrderResponseDto> orderResponse = new ArrayList<>();
        orders.stream().forEach(order ->
                orderResponse.add(new OrderResponseDto(order.getOrderNumber(), order.getAmount(),
                        new AddressResponseDto(order.getAddress().getStreet(), order.getAddress().getCity(),order.getAddress().getZipCode(),
                                new UserResponseDto(order.getUser().getFullName(),order.getUser().getEmail())))));
        return orderResponse;
    }

    public static OrderResponseDto convertOrder(Order order){
        return new OrderResponseDto(order.getOrderNumber(), order.getAmount(),
                new AddressResponseDto(order.getAddress().getStreet(),order.getAddress().getCity(),order.getAddress().getZipCode(),
                new UserResponseDto(order.getUser().getFullName(),order.getUser().getEmail())));
    }
}
