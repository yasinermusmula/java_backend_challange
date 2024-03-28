package com.example.s19challange.service;

import com.example.s19challange.entity.Role;
import com.example.s19challange.entity.User;
import com.example.s19challange.repository.RoleRepository;
import com.example.s19challange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;


    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(UserRepository userRepository,
                                 RoleRepository roleRepository,
                                 PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String userName,String email, String passwordHash){
        String encodedPasword = passwordEncoder.encode(passwordHash);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        User user = new User();
        user.setEmail(email);
        user.setFullName(userName);
        user.setPasswordHash(encodedPasword);
        user.setRoles(roles);

        return userRepository.save(user);
    }
}
