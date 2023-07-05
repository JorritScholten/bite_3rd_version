package com.ericwubbo.bite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    // from https://www.javaguides.net/2021/08/spring-boot-postgresql-crud-example.html
    @PostMapping
    public Item postItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable("id") long id) {
		itemRepository.deleteById(id);
    }
}
