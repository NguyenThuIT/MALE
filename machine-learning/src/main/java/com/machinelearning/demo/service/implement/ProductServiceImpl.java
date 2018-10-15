package com.machinelearning.demo.service.implement;

import com.machinelearning.demo.api.dto.created.ProductCreatedDTO;
import com.machinelearning.demo.api.dto.ProductDTO;
import com.machinelearning.demo.api.dto.updated.ProductUpdatedDTO;
import com.machinelearning.demo.api.mapper.ProductMapper;
import com.machinelearning.demo.domain.Category;
import com.machinelearning.demo.domain.Product;
import com.machinelearning.demo.repository.CategoryRepository;
import com.machinelearning.demo.repository.ProductRepository;
import com.machinelearning.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<ProductDTO> getAllProduct() {
        return productRepository.findAll().stream().map(productMapper::productToProductDTO).collect(Collectors.toSet());
    }

    @Override
    public ProductDTO addProduct(ProductCreatedDTO productCreatedDTO) {
        Product saveProduct = productRepository.save(productMapper.productCreatedDTOToProduct(productCreatedDTO));
        return productMapper.productToProductDTO(saveProduct);
    }

    @Override
    public ProductDTO updateProduct(ProductUpdatedDTO productUpdatedDTO){
        Product updatedProduct = productMapper.productUpdatedDTOToProduct(productUpdatedDTO);
        return productMapper.productToProductDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
