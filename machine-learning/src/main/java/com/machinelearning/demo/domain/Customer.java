package com.machinelearning.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    private String phone;

    @Email
    private String email;

    @OneToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "account_username")
    private Account account;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Order1> orders = new HashSet<>();

    public Customer removeOrder(Order1 order1){
        if(this.orders==null) {
            this.orders = new HashSet<>();
            return this;
        }
        if(order1!=null) this.orders.remove(order1);
        return this;

    }

    public Customer addOrder(Order1 order1){
        if(this.orders==null) {
            this.orders = new HashSet<>();
            return this;
        }
        if(order1!=null) this.orders.add(order1);
        return this;

    }
}
