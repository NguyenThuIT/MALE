package com.machinelearning.demo.api.mapper.impl;

import com.machinelearning.demo.api.dto.ProductDTO;
import com.machinelearning.demo.api.mapper.ItemMapper;
import com.machinelearning.demo.api.mapper.ProductMapper;
import com.machinelearning.demo.domain.Product;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProductMapperImpl implements ProductMapper {

    private final ItemMapper itemMapper;

    public ProductMapperImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public ProductDTO productToProductDTO(Product product) {
        if (product == null) return null;
        else {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setCost(product.getCost());
            productDTO.setAmount(product.getItems().size());
            productDTO.setDescription(product.getDescription());
            productDTO.setImage(product.getImage().getUrl());
            productDTO.setCategory(product.getCategory().getName());
            productDTO.setCategoryId(product.getCategory().getId());
            productDTO.setItems(product.getItems()
                    .stream()
                    .map(itemMapper::itemToItemDTO)
                    .collect(Collectors.toSet()));
            return productDTO;
        }
    }
}
