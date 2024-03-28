package com.example.s19challange.util;

import com.example.s19challange.dto.UserResponseDto;
import com.example.s19challange.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDtoConvertion {

    public static List<UserResponseDto> convertUserList(List<User> users){
        List<UserResponseDto> userResponses = new ArrayList<>();
        users.stream().forEach(user ->
                userResponses.add(new UserResponseDto(user.getFullName(), user.getEmail())));
        return userResponses;
    }

    public static UserResponseDto convertUser(User user){
        return new UserResponseDto(user.getFullName(), user.getEmail());
    }
}
