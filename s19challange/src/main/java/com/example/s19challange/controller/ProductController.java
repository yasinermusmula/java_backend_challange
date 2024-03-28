package com.example.s19challange.controller;

import com.example.s19challange.dto.ProductResponseDto;
import com.example.s19challange.entity.Product;
import com.example.s19challange.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @PostMapping("/{categoryId}")
    public ProductResponseDto save(@RequestBody Product product
                        , @PathVariable Long categoryId){
        return productService.save(product,categoryId);
    }

    @GetMapping("/")
    public List<ProductResponseDto> allProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDto findById(@PathVariable Long id){
        return productService.getById(id);
    }


    @DeleteMapping("/{id}")
    public ProductResponseDto delete(@PathVariable Long id){
        return productService.delete(id);
    }
}
