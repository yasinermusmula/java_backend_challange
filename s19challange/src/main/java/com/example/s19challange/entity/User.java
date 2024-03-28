package com.example.s19challange.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user",schema = "ecommerce")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String passwordHash;

    //User silinince adresslerde otomatik silinecek
    //Bir kullanıcının birden çok adresi olabilir
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Address> adresses;

    //Bir kullanıcının birden çok orderı olabilir
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Order> orders;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "app_user_role", schema = "fsweb",
            joinColumns = @JoinColumn(name = "app_user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public void addAdresses(Address address){
        if (address == null){
            adresses = new ArrayList<>();
        }
        adresses.add(address);
    }

    public void addOrders(Order order){
        if (orders == null){
            orders = new ArrayList<>();
        }
        orders.add(order);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
