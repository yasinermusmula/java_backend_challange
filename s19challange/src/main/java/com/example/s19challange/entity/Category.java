package com.example.s19challange.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category",schema = "ecommerce")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @Size(min = 2, max = 45, message = "Name must be between 2 and 45 caharacters")
    private String name;

    @Column(name = "description")
    @NotBlank(message = "You have to write description")
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public void addProduct(Product product){
        if (products == null){
            products = new ArrayList<>();
        }
        products.add(product);
    }
}
