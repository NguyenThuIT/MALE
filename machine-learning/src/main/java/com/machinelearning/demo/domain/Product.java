package com.machinelearning.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    private String description;

    private double cost;

    private int amount;

    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "product")
    private Set<Item> items = new HashSet<>();

    public Product removeItem(Item item){
        if(this.items==null) {
            this.items = new HashSet<>();
            return this;
        }
        if(item!=null) this.items.remove(item);
        return this;

    }
    public Product addItem(Item item){
        if(this.items==null) {
            this.items = new HashSet<>();
            return this;
        }
        if(item!=null) this.items.add(item);
        return this;

    }
}
