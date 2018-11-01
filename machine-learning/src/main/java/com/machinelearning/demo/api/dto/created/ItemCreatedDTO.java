package com.machinelearning.demo.api.dto.created;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemCreatedDTO {

    private Integer itemId;

    private Integer orderId;

    private Integer productId;

    private int amount;

    private double cost;
}
