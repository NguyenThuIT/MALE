package com.machinelearning.demo.api.dto;

import com.machinelearning.demo.domain.Account;
import com.machinelearning.demo.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    @NotBlank
    private String name;

    private String phone;

    @Email
    private String email;

    private Account account;

    private Set<Order> order = new HashSet<>();
}
