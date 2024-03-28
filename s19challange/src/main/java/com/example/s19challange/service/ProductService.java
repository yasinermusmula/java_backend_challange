package com.example.s19challange.service;

import com.example.s19challange.dto.ProductResponseDto;
import com.example.s19challange.entity.Product;

import java.util.List;

public interface ProductService {
    ProductResponseDto save(Product product,Long categoryId);

    List<ProductResponseDto> getAllProducts();

    List<ProductResponseDto> findByCategoryId(Long categoryId);

    ProductResponseDto getById(Long id);

    ProductResponseDto delete(Long id);

    Product findByOriginalId(Long id);
}
