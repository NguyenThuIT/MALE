package com.machinelearning.demo.api.dto;

import com.machinelearning.demo.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    @NotNull
    @NotBlank
    private Integer id;

    @NotBlank
    private String name;

    private String phone;

    @Email
    private String email;

    private String accountUsername;

    private Set<Order1DTO> order = new HashSet<>();
}
