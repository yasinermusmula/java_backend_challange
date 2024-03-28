package com.example.s19challange.repository;

import com.example.s19challange.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("SELECT o FROM Order o ORDER BY o.amount DESC ")
    List<Order> getByAmountDesc();

    @Query(value = "SELECT * FROM order ORDER BY amount ASC",nativeQuery = true)
    List<Order> getByAmountAsc();

}
