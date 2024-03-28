package com.example.s19challange.service;

import com.example.s19challange.dto.*;
import com.example.s19challange.entity.Address;
import com.example.s19challange.entity.Order;
import com.example.s19challange.entity.User;
import com.example.s19challange.repository.OrderRepository;
import com.example.s19challange.util.OrderDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    private final AddressService addressService;

    private final UserService userService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, AddressService addressService,UserService userService) {
        this.orderRepository = orderRepository;
        this.addressService = addressService;
        this.userService = userService;
    }

    @Override
    public OrderResponseDto save(Order order , Long addressId, Long userId) {
        Address address = addressService.findByOriginal(addressId);
        User user = userService.findByIdOriginal(userId);

        address.addOrders(order);
        user.addOrders(order);

        order.setAddress(address);
        order.setUser(user);

        orderRepository.save(order);
        return new OrderResponseDto(order.getOrderNumber(), order.getAmount(),
                new AddressResponseDto(address.getStreet(), address.getCity(), address.getZipCode(),
                        new UserResponseDto(user.getFullName(),user.getEmail())));
    }

    @Override
    public OrderResponseDto update(Order order, Long orderId) {
        Order existingOrder = findByOriginal(orderId);
        if (existingOrder != null){

            existingOrder.setOrderNumber(order.getOrderNumber());
            existingOrder.setAmount(order.getAmount());
            orderRepository.save(existingOrder);

            Address address = existingOrder.getAddress();
            User user = existingOrder.getUser();

            return new OrderResponseDto(existingOrder.getOrderNumber(), existingOrder.getAmount(),
                    new AddressResponseDto(address.getStreet(), address.getCity(), address.getZipCode(),
                            new UserResponseDto(user.getFullName(), user.getEmail())));
        }
        return null;
    }

    @Override
    public List<OrderResponseDto> findAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return OrderDtoConvertion.convertAddressList(orders);
    }

    @Override
    public Order findByOriginal(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()){
            return order.get();
        }
        //TODO Make Exception here
        return null;
    }

    @Override
    public OrderResponseDto findById(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()){
            Order order = orderOptional.get();
            return OrderDtoConvertion.convertOrder(order);
        }
        //TODO Make Exception Here
        return null;
    }

    @Override
    public OrderResponseDto delete(Long id) {
        OrderResponseDto order = findById(id);
        if (order != null){
            orderRepository.deleteById(id);
            return order;
        }
        // TODO Make exception here
        return null;
    }

    @Override
    public List<OrderResponseDto> getByPriceDesc() {
        List<Order> orderList = orderRepository.findAll();
        return OrderDtoConvertion.convertAddressList(orderList);
    }

    @Override
    public List<OrderResponseDto> getByPriceAsc() {
        List<Order> orderList = orderRepository.findAll();
        return OrderDtoConvertion.convertAddressList(orderList);
    }
}
