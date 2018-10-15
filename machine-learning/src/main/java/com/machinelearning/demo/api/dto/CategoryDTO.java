package com.machinelearning.demo.api.dto;

import com.machinelearning.demo.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    @NotBlank
    private String name;

    private String description;

    private Set<ProductDTO> products = new HashSet<>();
}
