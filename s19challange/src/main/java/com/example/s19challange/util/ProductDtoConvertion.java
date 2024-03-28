package com.example.s19challange.util;

import com.example.s19challange.dto.CategoryResponseDto;
import com.example.s19challange.dto.ProductResponseDto;
import com.example.s19challange.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDtoConvertion {

    public static List<ProductResponseDto> convertProductList(List<Product> products){
        List<ProductResponseDto> productResponse = new ArrayList<>();
        products.stream().forEach(product ->
                productResponse.add(new ProductResponseDto(product.getTitle(), product.getDepartment(), product.getPrice(),
                        new CategoryResponseDto(product.getCategory().getName(),
                                product.getCategory().getDescription()))));
        return productResponse;
    }


    public static ProductResponseDto convertProduct(Product product){
        return new ProductResponseDto(product.getTitle(),product.getDepartment(), product.getPrice(),
                new CategoryResponseDto(product.getCategory().getName(),
                        product.getCategory().getDescription()));
    }
}
