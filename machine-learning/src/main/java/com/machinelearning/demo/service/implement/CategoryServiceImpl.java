package com.machinelearning.demo.service.implement;

import com.machinelearning.demo.api.dto.CategoryDTO;
import com.machinelearning.demo.api.mapper.CategoryMapper;
import com.machinelearning.demo.domain.Category;
import com.machinelearning.demo.repository.CategoryRepository;
import com.machinelearning.demo.service.CategoryService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    /**
     * tim 1 category bang category
     * @param id
     * @return
     */
    @Override
    public CategoryDTO getCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent())
            return categoryMapper.categoryToCategoryDTO(optionalCategory.get());
        else
            throw new ObjectNotFoundException(id, "Category");
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        return categoryRepository.findAll().stream().map(categoryMapper::categoryToCategoryDTO).collect(Collectors.toList());
    }
}
