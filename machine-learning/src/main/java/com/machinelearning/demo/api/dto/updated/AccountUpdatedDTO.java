package com.machinelearning.demo.api.dto.updated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdatedDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
