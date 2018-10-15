package com.machinelearning.demo.api.dto.created;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreatedDTO {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
