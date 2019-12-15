package com.geekbrains.marketdemoa.controllers;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.geekbrains.marketdemoa.entites.Item;

import com.geekbrains.marketdemoa.services.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class RestApiController {
    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @JsonBackReference
    public List<Item> getAllItems() {
       return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getProductById(@PathVariable Long id) {
        return itemService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item saveNewProduct(@RequestBody Item item) {
        return itemService.save(item);
    }

    @DeleteMapping("/del/{id}")
    public void delProductById(@PathVariable Long id) {
        itemService.deleteItemById(id);
    }

    @PutMapping
    public Item updateProduct(@RequestBody Item item) {
        return itemService.save(item);
    }

}
