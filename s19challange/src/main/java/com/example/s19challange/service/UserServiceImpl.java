package com.example.s19challange.service;

import com.example.s19challange.dto.UserResponseDto;
import com.example.s19challange.entity.User;
import com.example.s19challange.exceptions.GlobalExceptions;
import com.example.s19challange.repository.UserRepository;
import com.example.s19challange.util.UserDtoConvertion;
import com.example.s19challange.validation.GlobalValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserResponseDto save(User user) {
//        Address address = addressService.findByOriginal();
        //TODO Make here convertion
        List<User> userList = userRepository.findUsersEmail(user.getFullName());
        GlobalValidation.isUserValid(user,userList);
        userRepository.save(user);
        return UserDtoConvertion.convertUser(user);
    }

    @Override
    public UserResponseDto delete(Long id) {
        UserResponseDto userResponseDto = findById(id);
        if (userResponseDto != null){
            userRepository.deleteById(id);
            return userResponseDto;
        }
        return null;
    }

    @Override
    public List<UserResponseDto> findAllUser() {
        List<User> userList = userRepository.findAll();
        return UserDtoConvertion.convertUserList(userList);
    }

    @Override
    public UserResponseDto findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            //TODO I will make some changes here
            //TODO I will return UserDtoConvertion here
            User user = userOptional.get();
            return UserDtoConvertion.convertUser(user);
        }
        //TODO Throw exception here
        throw new GlobalExceptions("This id is not valid", HttpStatus.BAD_REQUEST);
    }

    @Override
    public User findByIdOriginal(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            //TODO I will make some changes here
            //TODO I will return UserDtoConvertion here
            return userOptional.get();
        }
        //TODO Throw exception here
        throw new GlobalExceptions("This id is not valid", HttpStatus.BAD_REQUEST);
    }

    @Override
    public List<UserResponseDto> findUsersByEmail(String email) {
        //TODO Make Conversion Dto in here
        List<User> userList = userRepository.findUsersEmail(email);
        return UserDtoConvertion.convertUserList(userList);
    }
}
