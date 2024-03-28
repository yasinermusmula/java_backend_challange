package com.example.s19challange.util;

import com.example.s19challange.dto.CategoryResponseDto;
import com.example.s19challange.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDtoConvertion {

    public static List<CategoryResponseDto> convertCategoryList(List<Category> categories){
        List<CategoryResponseDto> categoryResponse = new ArrayList<>();
        categories.stream().forEach(category ->
                categoryResponse.add(new CategoryResponseDto(category.getName(),category.getDescription())));
        return categoryResponse;
    }
    public static CategoryResponseDto convertCategory(Category category){
        return new CategoryResponseDto(category.getName(),category.getDescription());
    }
}
