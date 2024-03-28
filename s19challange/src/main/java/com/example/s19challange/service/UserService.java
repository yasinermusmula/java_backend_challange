package com.example.s19challange.service;

import com.example.s19challange.dto.UserResponseDto;
import com.example.s19challange.entity.User;

import java.util.List;

public interface UserService {
    UserResponseDto save(User user);

    UserResponseDto delete(Long id);

    List<UserResponseDto> findAllUser();

    UserResponseDto findById(Long id);

    User findByIdOriginal(Long id);

    List<UserResponseDto> findUsersByEmail(String name);
}
