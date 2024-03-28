package com.example.s19challange.controller;

import com.example.s19challange.dto.UserResponseDto;
import com.example.s19challange.entity.User;
import com.example.s19challange.service.AuthenticationService;
import com.example.s19challange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public List<UserResponseDto> findAll(){
        return userService.findAllUser();
    }

    @GetMapping("/{userId}")
    public UserResponseDto findById(@PathVariable Long userId){
        return userService.findById(userId);
    }

    @GetMapping("/byName/{name}")
    public List<UserResponseDto> findUsersByEmail(@PathVariable String email){
        return userService.findUsersByEmail(email);
    }

    @DeleteMapping("/{id}")
    public UserResponseDto delete(@PathVariable Long id){
        return userService.delete(id);
    }
}
