package com.example.s19challange.controller;

import com.example.s19challange.dto.RegisterResponseDto;
import com.example.s19challange.entity.User;
import com.example.s19challange.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/signup")
public class AuthController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterResponseDto registerResponseDto){
        return authenticationService.register(registerResponseDto.userName(), registerResponseDto.email(),
                registerResponseDto.password());
    }
}
