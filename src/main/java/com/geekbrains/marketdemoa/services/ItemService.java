package com.geekbrains.marketdemoa.services;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.geekbrains.marketdemoa.entites.Item;
import com.geekbrains.marketdemoa.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Page<Item> findAll(Specification<Item> spec, Pageable pageable) {
        return itemRepository.findAll(spec, pageable);
    }

    public Item findById(Long id) {
        return itemRepository.findById(id).get();
    }
    public Item save(Item item) {
        return itemRepository.save(item);
    }


    public List<Item> getAllItems() {
       return itemRepository.findAll();
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }


}
