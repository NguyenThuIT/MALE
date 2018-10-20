package com.machinelearning.demo.controller;

import com.machinelearning.demo.api.dto.CategoryDTO;
import com.machinelearning.demo.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping({"","/category"})
@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping({"","/"})
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDTO> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategory(@PathVariable Long categoryId){
        return categoryService.getCategory(categoryId);
    }
}
