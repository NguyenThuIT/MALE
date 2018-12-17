package com.machinelearning.demo.api.dto.updated;

import com.machinelearning.demo.domain.Image;
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
    private Integer id;

    @NotBlank
    private String name;

    private String description;

    private double cost;

    private int amount;

    private Image image;

    private Integer orderId;

    private String category;

    private Integer categoryId;
}
