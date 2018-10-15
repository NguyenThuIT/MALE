package com.machinelearning.demo.api.mapper.impl;

import com.machinelearning.demo.api.dto.CategoryDTO;
import com.machinelearning.demo.api.dto.ProductDTO;
import com.machinelearning.demo.api.mapper.CategoryMapper;
import com.machinelearning.demo.api.mapper.ProductMapper;
import com.machinelearning.demo.domain.Category;
import com.machinelearning.demo.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    private final ProductMapper productMapper;

    public CategoryMapperImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public CategoryDTO categoryToCategoryDTO(Category category) {
        if(category==null) return null;
        else {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setName(category.getName());
            categoryDTO.setDescription(category.getDescription());
            categoryDTO.setProducts(category.getProducts().stream()
                    .map(productMapper::productToProductDTO)
                    .collect(Collectors.toSet()));
            return categoryDTO;
        }
    }
}
