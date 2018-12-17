package com.machinelearning.demo.api.dto;

import com.machinelearning.demo.domain.Customer;
import com.machinelearning.demo.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order1DTO {

    @NotNull
    @NotBlank
    private Integer id;

    @NotBlank
    private String dateCreated;

    private int amount;

    private double price;

    private String customerName;

    private Integer customerId;

    private Set<ItemDTO> items = new HashSet<>();
}
