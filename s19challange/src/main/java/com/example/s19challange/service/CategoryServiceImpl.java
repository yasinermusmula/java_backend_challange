package com.example.s19challange.service;

import com.example.s19challange.dto.CategoryResponseDto;
import com.example.s19challange.entity.Category;
import com.example.s19challange.repository.CategoryRepository;
import com.example.s19challange.util.CategoryDtoConvertion;
import com.example.s19challange.validation.GlobalValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryResponseDto findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            return CategoryDtoConvertion.convertCategory(category);
        }
        //TODO Make Exception here
        return null;
    }

    @Override
    public Category findByIdOriginal(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()){
            return categoryOptional.get();
        }
        //TODO Make Exception Here
        return null;
    }

    @Override
    public CategoryResponseDto delete(Long id) {
        CategoryResponseDto categoryResponse = findById(id);
        categoryRepository.deleteById(id);
        return categoryResponse;
    }

    @Override
    public CategoryResponseDto save(Category category) {
        List<Category> categories = categoryRepository.findAll();
        GlobalValidation.isValidCategory(category,categories);
        Category savedCategory = categoryRepository.save(category);
        return CategoryDtoConvertion.convertCategory(category);
    }

    @Override
    public List<CategoryResponseDto> findCategoriesByName(String name) {
        List<Category> categories = categoryRepository.findCategoriesByName(name);
        return CategoryDtoConvertion.convertCategoryList(categories);
    }
}
