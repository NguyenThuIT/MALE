package com.machinelearning.demo.service;

import com.machinelearning.demo.api.dto.created.ProductCreatedDTO;
import com.machinelearning.demo.api.dto.ProductDTO;
import com.machinelearning.demo.api.dto.updated.ProductUpdatedDTO;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;

public interface ProductService {
    Set<ProductDTO> getAllProduct();

    ProductDTO addProduct(ProductCreatedDTO productCreatedDTO);

    ProductDTO updateProduct(ProductUpdatedDTO productUpdatedDTO);

    ProductDTO getSingleProduct(Long productId);

    void deleteProduct(Long id);
}
