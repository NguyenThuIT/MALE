package com.machinelearning.demo.service;

import com.machinelearning.demo.api.dto.CategoryDTO;
import com.machinelearning.demo.domain.Category;

import java.util.List;

public interface CategoryService {

    CategoryDTO getCategory(Long id);

    List<CategoryDTO> getAllCategory();
}
