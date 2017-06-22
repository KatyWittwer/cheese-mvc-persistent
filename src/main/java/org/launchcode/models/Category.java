package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 6/19/2017.
 */

@Entity

public class Category {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    //Each one category will have many cheeses,
    // but each cheese can have only one category.
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Cheese> cheeses = new ArrayList<>();

    public List<Cheese> getCheeses() {
        return cheeses;
    }

    public Category() { }

    public Category(String name) {this.name = name; }

    public int getId() {return id; }

    public void setName(String name) {this.name = name; }

    public String getName() {
        return name;
    }
    public void setCheeses(List<Cheese> cheeses) {
        this.cheeses = cheeses;
    }

}

