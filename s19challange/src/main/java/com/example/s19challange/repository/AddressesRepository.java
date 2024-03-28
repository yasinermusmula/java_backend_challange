package com.example.s19challange.repository;

import com.example.s19challange.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressesRepository extends JpaRepository<Address,Long> {

    @Query("SELECT a FROM Address a WHERE a.city = :name")
    List<Address> findAddressByName(String name);
}
