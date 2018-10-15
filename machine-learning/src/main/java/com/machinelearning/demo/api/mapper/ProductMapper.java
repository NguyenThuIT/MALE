package com.machinelearning.demo.api.mapper;

import com.machinelearning.demo.api.dto.created.ProductCreatedDTO;
import com.machinelearning.demo.api.dto.ProductDTO;
import com.machinelearning.demo.api.dto.updated.ProductUpdatedDTO;
import com.machinelearning.demo.domain.Product;

public interface ProductMapper {
    ProductDTO productToProductDTO(Product product);

    Product productCreatedDTOToProduct(ProductCreatedDTO productCreatedDTO);

    Product productUpdatedDTOToProduct(ProductUpdatedDTO productUpdatedDTO);
}
