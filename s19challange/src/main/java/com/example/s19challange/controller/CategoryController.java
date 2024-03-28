package com.example.s19challange.controller;

import com.example.s19challange.dto.CategoryResponseDto;
import com.example.s19challange.entity.Category;
import com.example.s19challange.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public CategoryResponseDto save(@Valid @RequestBody Category category){
        return categoryService.save(category);
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @GetMapping("byName/{name}")
    public List<CategoryResponseDto> findByName(@PathVariable String name) {
        return categoryService.findCategoriesByName(name);
     }

     @DeleteMapping("/{id}")
    public CategoryResponseDto delete(@PathVariable Long id){
        return categoryService.delete(id);
     }

}
