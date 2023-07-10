package com.ericwubbo.bite;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Basket {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade= CascadeType.ALL, mappedBy = "basket")
    private Set<BasketItem> basketItems;

    private LocalDateTime dateTime;

    // should at one point also get user.
}
