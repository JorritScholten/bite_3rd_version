package com.ericwubbo.bite.basket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Set;

@RestController
@RequestMapping("api/v1/baskets")
public class BasketController {

    @Autowired
    private BasketRepository basketRepository;

    @GetMapping("")
    public Set<Basket> test() {
       return basketRepository.findByDateTimeIsAfter(LocalDateTime.now().minusDays(1));
    }

}
