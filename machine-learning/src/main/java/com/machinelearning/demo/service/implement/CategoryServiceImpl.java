package com.machinelearning.demo.service.implement;

import com.machinelearning.demo.api.dto.CategoryDTO;
import com.machinelearning.demo.api.mapper.CategoryMapper;
import com.machinelearning.demo.domain.Category;
import com.machinelearning.demo.exception.ResourceNotFoundException;
import com.machinelearning.demo.repository.CategoryRepository;
import com.machinelearning.demo.repository.ProductRepository;
import com.machinelearning.demo.service.CategoryService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final ProductRepository productRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               CategoryMapper categoryMapper, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.productRepository = productRepository;
    }

    /**
     * tim 1 category bang category
     * @param id
     * @return
     */
    @Override
    public CategoryDTO getCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent())
            return categoryMapper.categoryToCategoryDTO(optionalCategory.get());
        else
            throw new ResourceNotFoundException("Category " + id + " not found");
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        return categoryRepository.findAll().stream().map(categoryMapper::categoryToCategoryDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(int categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if(!optionalCategory.isPresent()){
            throw new ResourceNotFoundException("Category " + categoryId + " not found");
        }
        else {
            throw new ResourceNotFoundException("Having " + productRepository.count() + " product is running");
        }
    }
}
