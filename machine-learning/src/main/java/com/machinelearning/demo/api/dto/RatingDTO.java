package com.machinelearning.demo.api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingDTO {

    private Integer rateId;

    private double ratingCount;

    private Integer itemId;

    private String accountUsername;
}
