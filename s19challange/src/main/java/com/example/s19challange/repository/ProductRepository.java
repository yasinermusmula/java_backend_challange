package com.example.s19challange.repository;

import com.example.s19challange.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "SELECT p.* FROM ecommerce.product WHERE p.category_id = :categoryId",nativeQuery = true)
    List<Product> findByCategoryId(Long categoryId);
}
