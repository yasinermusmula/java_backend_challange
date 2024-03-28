package com.example.s19challange.service;

import com.example.s19challange.dto.CategoryResponseDto;
import com.example.s19challange.dto.ProductResponseDto;
import com.example.s19challange.entity.Category;
import com.example.s19challange.entity.Product;
import com.example.s19challange.exceptions.GlobalExceptions;
import com.example.s19challange.repository.ProductRepository;
import com.example.s19challange.util.ProductDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    private CategoryService categoryService;

    @Override
    public ProductResponseDto save(Product product,Long categoryId) {
        //1. categoryID den Category'yi bul.
        Category category = categoryService.findByIdOriginal(categoryId);
        //2. categorynin product listesini yeni product ı ekle.
        category.addProduct(product);
        //3. Product'a categoryi ekle.
        product.setCategory(category);
        //4. Productı save et.
        Product savedProduct = productRepository.save(product);


        return new ProductResponseDto(product.getTitle(), product.getDepartment(), product.getPrice(),
                new CategoryResponseDto(category.getName(),category.getDescription()));
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ProductDtoConvertion.convertProductList(products);
    }

    @Override
    public List<ProductResponseDto> findByCategoryId(Long categoryId) {
        Category category = categoryService.findByIdOriginal(categoryId);

        List<ProductResponseDto> productResponse = new ArrayList<>();
        category.getProducts().stream()
                .forEach(product -> productResponse.add(new ProductResponseDto(product.getTitle(),
                        product.getDepartment(), product.getPrice(),
                        new CategoryResponseDto(category.getName(), category.getDescription()))));
        return null;
    }

    @Override
    public ProductResponseDto getById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            return ProductDtoConvertion.convertProduct(product);
        }
        throw new GlobalExceptions("pruduct that given id is not cradential", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ProductResponseDto delete(Long id) {
        ProductResponseDto productResponseDto = getById(id);
        productRepository.deleteById(id);
        //TODO Make Exceptions Here
        return productResponseDto;
    }

    @Override
    public Product findByOriginalId(Long id) {
        Optional <Product> product = productRepository.findById(id);
        if (product.isPresent()){
            return product.get();
        }
        //Todo Make Exception
        return null;
    }
}
