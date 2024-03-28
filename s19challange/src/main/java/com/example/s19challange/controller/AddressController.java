package com.example.s19challange.controller;

import com.example.s19challange.dto.AddressResponseDto;
import com.example.s19challange.entity.Address;
import com.example.s19challange.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/{userId}")
    public AddressResponseDto save(@RequestBody Address address,
                                   @PathVariable Long userId){
        return addressService.save(address,userId);
    }

    @GetMapping("/")
    public List<AddressResponseDto> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressResponseDto findById(@PathVariable Long id){
        return addressService.findById(id);
    }

    @GetMapping("adressName/{name}")
    public List<AddressResponseDto> findByAdressName(@PathVariable String name){
        return addressService.findAddressesByName(name);
    }

    @DeleteMapping("/{id}")
    public AddressResponseDto delete(@PathVariable Long id){
        return addressService.delete(id);
    }
}
