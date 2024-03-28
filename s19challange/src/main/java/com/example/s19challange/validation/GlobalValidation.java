package com.example.s19challange.validation;

import com.example.s19challange.entity.Category;
import com.example.s19challange.entity.User;
import com.example.s19challange.exceptions.GlobalExceptions;
import org.springframework.http.HttpStatus;

import java.util.List;

public class GlobalValidation {

    public static final String NAME_OR_EMAIL_IS_NOT_VALID = "This name or this email has given a user";
    public static final String CATEGORY_NAME_IS_VALID = "This category was given";


    public static void isUserValid(User user, List<User> users){
        for (User existingUser : users){
            if (existingUser.getFullName().equalsIgnoreCase(user.getFullName()) ||
                existingUser.getEmail().equalsIgnoreCase(user.getEmail())){
                throw new GlobalExceptions(NAME_OR_EMAIL_IS_NOT_VALID, HttpStatus.BAD_REQUEST);
            }
        }
    }

    public static void isValidCategory(Category category, List<Category> categories){
        for (Category existingCategory: categories){
            if (existingCategory.getId().equals(category.getId()) ||
                    existingCategory.getName().equalsIgnoreCase(category.getName()) ||
                    existingCategory.getDescription().equalsIgnoreCase(category.getDescription())){
                throw new GlobalExceptions(CATEGORY_NAME_IS_VALID, HttpStatus.BAD_REQUEST);
            }
        }
    }

}
