package com.ericwubbo.bite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemSeeder implements CommandLineRunner {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    BasketRepository basketRepository;

    @Override
    public void run(String... args) {
        seedItems();
        seedBasket();
    }

    private void seedBasket() {
        long count = basketRepository.count();
        if (count == 0) {
            System.out.println("Seeding basket");
            Item apples = itemRepository.findByName("apples").stream().findFirst().get();
            Item pears = itemRepository.findByName("pears").stream().findFirst().get();
            var basket = new Basket();
            BasketItem applesOrder = new BasketItem(apples, basket, 1);
            System.out.println(apples);
        }
        System.out.println(count + " items in the database.");
    }

    private void seedItems() {
        long count = itemRepository.count();
        if (count == 0) {
            System.out.println("Seeding items");
            List<Item> items = List.of(
                    new Item("apples", "2.25"),
                    new Item("bananas", "3.79"),
                    new Item("pears", "4.50"),
                    new Item("prunes", "1.20"));
            for (Item item : items) {
                itemRepository.save(item);
            }
            count = itemRepository.count();
        }
        System.out.println(count + " items in the database.");
    }
}