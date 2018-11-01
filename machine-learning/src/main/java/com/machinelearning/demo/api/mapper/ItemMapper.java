package com.machinelearning.demo.api.mapper;

import com.machinelearning.demo.api.dto.ItemDTO;
import com.machinelearning.demo.domain.Item;

public interface ItemMapper {
    ItemDTO itemToItemDTO(Item item);
}
