package com.machinelearning.demo.api.mapper.impl;

import com.machinelearning.demo.api.dto.ItemDTO;
import com.machinelearning.demo.api.mapper.ItemMapper;
import com.machinelearning.demo.domain.Item;
import com.machinelearning.demo.repository.ItemRepository;
import org.springframework.stereotype.Component;

@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public ItemDTO itemToItemDTO(Item item) {
        if (item == null) return null;
        else {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setItemId(item.getId());
            itemDTO.setAmount(item.getAmount());
            itemDTO.setCost(item.getCost());
            itemDTO.setOrderId(item.getOrder1().getId());
            itemDTO.setProductId(item.getProduct().getId());
            return itemDTO;
        }
    }
}
