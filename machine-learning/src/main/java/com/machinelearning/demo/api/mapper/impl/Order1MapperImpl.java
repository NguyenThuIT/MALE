package com.machinelearning.demo.api.mapper.impl;

import com.machinelearning.demo.api.dto.Order1DTO;
import com.machinelearning.demo.api.mapper.ItemMapper;
import com.machinelearning.demo.api.mapper.Order1Mapper;
import com.machinelearning.demo.domain.Order1;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Order1MapperImpl implements Order1Mapper {

    private final ItemMapper itemMapper;

    public Order1MapperImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public Order1DTO orderToOrder1DTO(Order1 order1) {
        if (order1 == null) return null;
        else {
            Order1DTO order1DTO = new Order1DTO();
            order1DTO.setId(order1.getId());
            order1DTO.setAmount(order1.getItems().size());
            order1DTO.setDateCreated(order1.getDateCreated());
            order1DTO.setPrice(order1.getPrice());
            order1DTO.setCustomerName(order1.getCustomer().getName());
            order1DTO.setCustomerId(order1.getCustomer().getId());
            order1DTO.setItems(order1.getItems()
                    .stream()
                    .map(itemMapper::itemToItemDTO)
                    .collect(Collectors.toSet()));
            return order1DTO;
        }
    }
}
