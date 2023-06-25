package com.ericwubbo.bite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemSeeder implements CommandLineRunner {
    @Autowired
    ItemRepository itemRepository;

    @Override
    public void run(String... args) {
        long count = itemRepository.count();
        if (count == 0) {
            System.out.println("Seeding items");
            List<Item> items = List.of(
                    new Item("apples", "2.25"),
                    new Item("bananas", "3.79"),
                    new Item("pears", "4.50"),
                    new Item("prunes", "1.20"));
            for (Item item: items) {
                itemRepository.save(item);
            }
            count = itemRepository.count();
        }
        System.out.println(count + " items in the database.");
    }
}