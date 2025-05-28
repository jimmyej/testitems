package com.devskiller.controller;

import com.devskiller.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService service;

    @Autowired
    public ItemController(ItemService service){
        this.service = service;
    }

    @GetMapping(value = "/titles/{rating}", produces = "application/json;charset=UTF-8")
    public List<String> getTitles(@PathVariable Double rating) {
        List<String> titles;
        try{
            titles = service.getTitlesWithAverageRatingLowerThan(rating);
        } catch (Exception e){
            throw new UnsupportedOperationException();
        }
        return  titles;
    }
}
