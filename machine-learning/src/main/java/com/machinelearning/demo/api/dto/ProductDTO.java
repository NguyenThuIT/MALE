package com.machinelearning.demo.api.dto;

import com.machinelearning.demo.domain.Category;
import com.machinelearning.demo.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotBlank
    private String name;

    private String description;

    private double cost;

    private int amount;

    private String image;

    private String category;

    private Long categoryId;

    private Set<Order> orders = new HashSet<>();
}