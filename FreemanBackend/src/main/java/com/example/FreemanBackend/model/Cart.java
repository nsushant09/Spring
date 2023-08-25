package com.example.FreemanBackend.model;

import com.example.FreemanBackend.core.Constants;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = Constants.CART_TABLE)
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public User user;

    @ManyToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    public Set<Product> products = new LinkedHashSet<>();
}
