package com.machinelearning.demo.api.dto;

import com.machinelearning.demo.domain.Order1;
import com.machinelearning.demo.domain.Product;
import com.machinelearning.demo.domain.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    private Integer itemId;

    private String itemName;

    private Integer orderId;

    private Integer productId;

    private int amount;

    private double cost;

    private double ratingCount;
}
