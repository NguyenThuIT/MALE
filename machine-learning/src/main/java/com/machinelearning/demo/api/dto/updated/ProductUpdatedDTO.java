package com.machinelearning.demo.api.dto.updated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdatedDTO {

    @NotBlank
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    private String description;

    private double cost;

    private int amount;

    private String image;

    private Long orderId;

    private String category;

    private Long categoryId;
}
