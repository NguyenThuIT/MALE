package com.machinelearning.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Order1 order1;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;

    @Column(name = "item_amount")
    private int amount;

    @Column(name = "order_cost")
    private double cost;
}
