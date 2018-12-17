package com.machinelearning.demo.service;

import com.machinelearning.demo.api.dto.ItemDTO;
import com.machinelearning.demo.api.dto.created.ItemCreatedDTO;

import java.util.Set;

public interface ItemService {
    Set<ItemDTO> getAllItem();

    ItemDTO getSingleItem(Integer itemId);

    ItemDTO addItem(ItemCreatedDTO itemCreatedDTO);

    ItemDTO updateItem(ItemDTO itemDTO);

    void deleteItem(Integer itemId);
}
