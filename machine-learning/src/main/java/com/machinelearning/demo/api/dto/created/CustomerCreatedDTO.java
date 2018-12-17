package com.machinelearning.demo.api.dto.created;

import com.machinelearning.demo.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCreatedDTO {
    @NotNull
    @NotBlank
    private Integer id;

    @NotBlank
    private String name;

    private String phone;

    @Email
    private String email;

    private Account account;
}
