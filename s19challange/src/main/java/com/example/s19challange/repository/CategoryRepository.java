package com.example.s19challange.repository;

import com.example.s19challange.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("SELECT c FROM Category c WHERE c.name = :name")
    List<Category> findCategoriesByName(String name);

}
