package com.example.s19challange.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "adreses", schema = "ecommerce")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private Integer zipCode;

    //Adress silindiğinde user silinmeyecek
    //Bir adres bir kullanıcınındır.
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    //Adress silindiğinde order silinmeyecek
    //Bir adres bir kullanıcınındır.
    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "order_id",nullable = false)
    private List<Order> orders;

    public void addOrders(Order order){
        if (orders == null){
            orders = new ArrayList<>();
        }
        orders.add(order);
        order.setAddress(this);
    }
}
