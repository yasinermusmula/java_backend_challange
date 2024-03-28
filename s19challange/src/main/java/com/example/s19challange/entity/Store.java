package com.example.s19challange.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store",schema = "ecommerce")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "store_phone")
    private String storePhone;

    @Column(name = "tax_number")
    private String taxNumber;

    @Column(name = "bank_account")
    private String bankAccount;
}

