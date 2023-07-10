package com.ericwubbo.bite.item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Item {
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
