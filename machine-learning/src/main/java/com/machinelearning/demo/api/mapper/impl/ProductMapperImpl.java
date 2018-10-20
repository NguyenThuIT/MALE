package com.machinelearning.demo.api.mapper.impl;

import com.machinelearning.demo.api.dto.created.ProductCreatedDTO;
import com.machinelearning.demo.api.dto.ProductDTO;
import com.machinelearning.demo.api.dto.updated.ProductUpdatedDTO;
import com.machinelearning.demo.api.mapper.ProductMapper;
import com.machinelearning.demo.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO productToProductDTO(Product product) {
        if (product == null) return null;
        else {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setCost(product.getCost());
            productDTO.setAmount(product.getAmount());
            productDTO.setDescription(product.getDescription());
            productDTO.setImage(product.getImage());
            productDTO.setCategory(product.getCategory().getName());
            productDTO.setCategoryId(product.getCategory().getId());
            return productDTO;
        }
    }
}
