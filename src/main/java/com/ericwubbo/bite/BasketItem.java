package com.ericwubbo.bite;

import jakarta.persistence.*;

@Entity
public class BasketItem {
    @Id // Ideally composite key out of itemId and basketId
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item item;

    @ManyToOne
    @JoinColumn(name="basket_id", nullable=false)
    private Basket basket;

    private int count;

    public BasketItem(Item item, Basket basket, int count) {
        this.item = item;
        this.basket = basket;
        this.count = count;
    }
}
