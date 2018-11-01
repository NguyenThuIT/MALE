package com.machinelearning.demo.controller;

import com.machinelearning.demo.api.dto.ItemDTO;
import com.machinelearning.demo.api.dto.created.ItemCreatedDTO;
import com.machinelearning.demo.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("/item")
@RestController
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Set<ItemDTO> getAllItem(){
        return itemService.getAllItem();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ItemDTO getSingleItem(@PathVariable("id") Integer itemId){
        return itemService.getSingleItem(itemId);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO addItem(@RequestBody ItemCreatedDTO itemCreatedDTO){
        return itemService.addItem(itemCreatedDTO);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable("id") Integer itemId){
        itemService.deleteItem(itemId);
        return;
    }
}
