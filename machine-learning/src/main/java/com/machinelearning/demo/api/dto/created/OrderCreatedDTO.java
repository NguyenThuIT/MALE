package com.machinelearning.demo.api.dto.created;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedDTO {

    @NotNull
    @NotBlank
    private Integer id;

    @NotBlank
    private String dateCreated;

    private int amountItem;

    private double price;

    private String customerName;

    private Integer customerId;
}
