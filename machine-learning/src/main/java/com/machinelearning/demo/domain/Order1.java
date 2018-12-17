package com.machinelearning.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int amount;

    private double price;

    private String dateCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "order1")
    private Set<Item> items = new HashSet<>();

    public Order1 removeItem(Item item){
        if(this.items==null) {
            this.items = new HashSet<>();
            return this;
        }
        if(item!=null) this.items.remove(item);
        return this;

    }
    public Order1 addItem(Item item){
        if(this.items==null) {
            this.items = new HashSet<>();
            return this;
        }
        if(item!=null) this.items.add(item);
        return this;

    }

}
