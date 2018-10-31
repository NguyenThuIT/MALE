package com.machinelearning.demo.api.dto;

import com.machinelearning.demo.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private Customer customer;
}
