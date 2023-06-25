package com.ericwubbo.bite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private BigDecimal price;

    private Item() {}

    public Item(String name, String price) {
        this.name = name;
        this.price = new BigDecimal(price);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
