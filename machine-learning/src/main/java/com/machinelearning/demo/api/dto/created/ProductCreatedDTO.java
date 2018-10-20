package com.machinelearning.demo.api.dto.created;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreatedDTO {
    @NotBlank
    private String name;

    private String description;

    private double cost;

    private int amount;

    private String image;

    private Integer orderId;

    private String category;

    private Integer categoryId;
}
