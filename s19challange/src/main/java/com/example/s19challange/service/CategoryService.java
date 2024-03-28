package com.example.s19challange.service;

import com.example.s19challange.dto.CategoryResponseDto;
import com.example.s19challange.entity.Category;

import java.util.List;

public interface CategoryService{
    List<Category> findAll();

    CategoryResponseDto findById(Long id);

    Category findByIdOriginal(Long id);

    CategoryResponseDto delete(Long id);

    CategoryResponseDto save(Category category);

    List<CategoryResponseDto> findCategoriesByName(String name);

}
