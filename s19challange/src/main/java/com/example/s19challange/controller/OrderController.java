package com.example.s19challange.controller;

import com.example.s19challange.dto.OrderResponseDto;
import com.example.s19challange.entity.Order;
import com.example.s19challange.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    //request param
    @PostMapping("/{adressId}/{userId}")
    public OrderResponseDto save(@RequestBody Order order,
                                 @PathVariable Long adressId,
                                 @PathVariable Long userId){
        return orderService.save(order,adressId,userId);
    }

    @GetMapping("/")
    public List<OrderResponseDto> findAllOrders(){
        return orderService.findAllOrders();
    }

    @GetMapping("/{id}")
    public OrderResponseDto findById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @GetMapping("/desc")
    public List<OrderResponseDto> getByPriceDesc(){
        return orderService.getByPriceDesc();
    }

    @GetMapping("/asc")
    public List<OrderResponseDto> getByPriceAsc(){
        return orderService.getByPriceAsc();
    }

    @PutMapping("/{id}")
    public OrderResponseDto update(@RequestBody Order order, @PathVariable Long id){
        return orderService.update(order,id);
    }

    @DeleteMapping("/{id}")
    public OrderResponseDto delete(@PathVariable Long id){
        return orderService.delete(id);
    }
}
