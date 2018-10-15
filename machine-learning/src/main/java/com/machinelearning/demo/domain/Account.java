package com.machinelearning.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {

    @Id
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @OneToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
