package com.machinelearning.demo.api.dto;

import com.machinelearning.demo.domain.Customer;
import com.machinelearning.demo.domain.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private Set<RatingDTO> rating = new HashSet<>();
}
