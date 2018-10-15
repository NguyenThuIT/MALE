package com.machinelearning.demo.api.mapper;

import com.machinelearning.demo.api.dto.CategoryDTO;
import com.machinelearning.demo.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    CategoryDTO categoryToCategoryDTO(Category category);
}
