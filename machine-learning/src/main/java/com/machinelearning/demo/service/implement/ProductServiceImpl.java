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
import org.hibernate.ObjectNotFoundException;
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
        Optional<Category> optionalCategory = categoryRepository.findById(productCreatedDTO.getCategoryId());
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();

            Product product = new Product();
            product.setName(productCreatedDTO.getName());
            product.setAmount(productCreatedDTO.getAmount());
            product.setCost(productCreatedDTO.getCost());
            product.setDescription(productCreatedDTO.getDescription());
            product.setImage(productCreatedDTO.getImage());
            product.setCategory(category);
            productRepository.save(product);

            category.getProducts().add(product);
            categoryRepository.save(category);

            return productMapper.productToProductDTO(product);
        } else {
            throw new RuntimeException("Category not found");
        }
    }

    @Override
    public ProductDTO updateProduct(ProductUpdatedDTO productUpdatedDTO){
        Optional<Product> optionalProduct = productRepository.findById(productUpdatedDTO.getId());
        if (!optionalProduct.isPresent()) {
            return null;
        }
        Product product = optionalProduct.get();
        if (productUpdatedDTO.getCategoryId() != null) {
            Category category = product.getCategory();
            categoryRepository.save(category.removeProduct(product));

            Optional<Category> optionalCategory = categoryRepository.findById(productUpdatedDTO.getCategoryId());
            if (optionalCategory.isPresent()) {
                categoryRepository.save(optionalCategory.get().addProduct(product));
                product.setCategory(optionalCategory.get());
            }

        }
        if (productUpdatedDTO.getName() != null) {
            product.setName(productUpdatedDTO.getName());
        }
        if (productUpdatedDTO.getDescription() != null) {
            product.setDescription(productUpdatedDTO.getDescription());
        }
        if (productUpdatedDTO.getCost() != product.getCost()) {
            product.setCost(productUpdatedDTO.getCost());
        }
        if (productUpdatedDTO.getImage() != null) {
            product.setImage(productUpdatedDTO.getImage());
        }

        if (productUpdatedDTO.getAmount() != product.getAmount()) {
            product.setAmount(productUpdatedDTO.getAmount());
        }

        Product savedProduct = productRepository.save(product);
        return productMapper.productToProductDTO(savedProduct);
    }

    @Override
    public ProductDTO getSingleProduct(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            return productMapper.productToProductDTO(optionalProduct.get());
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
