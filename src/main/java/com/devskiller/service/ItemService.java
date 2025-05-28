package com.devskiller.service;

import com.devskiller.dao.ItemRepository;
import com.devskiller.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<String> getTitlesWithAverageRatingLowerThan(Double rating) {
        List<Item> items;
        List<String> titles;
        try {
            items = itemRepository.findByItemWithAverageRatingLowerThan(rating);
            titles = items.stream().map(Item::getTitle).collect(Collectors.toList());
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
        return titles;
    }

}
