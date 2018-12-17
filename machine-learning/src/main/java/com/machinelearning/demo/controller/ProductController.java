package com.machinelearning.demo.controller;

import com.machinelearning.demo.api.dto.ProductDTO;
import com.machinelearning.demo.api.dto.created.ProductCreatedDTO;
import com.machinelearning.demo.api.dto.updated.ProductUpdatedDTO;
import com.machinelearning.demo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("/product")
@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Set<ProductDTO> products(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getSingleProduct(@PathVariable("id") Integer productId){
        return productService.getSingleProduct(productId);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO addProducts(@RequestBody ProductCreatedDTO productCreatedDTO){
        return productService.addProduct(productCreatedDTO);
    }

    @PatchMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO updateProduct(@RequestBody ProductUpdatedDTO productUpdatedDTO){
        return productService.updateProduct(productUpdatedDTO);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable("id") Integer id){
        productService.deleteProduct(id);
    }
}
