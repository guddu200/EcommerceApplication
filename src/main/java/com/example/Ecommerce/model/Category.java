package com.example.Ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "ecommerce_category")

public class Category {


    @Id
    @GeneratedValue()
    @Column(name = "category_id")
    private int id;
    @Column(name = "category_name")
    private String name;
    @Column(name = "category_description")
    private String description;

//    @OneToMany(fetch =FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
//    private List<Product> addressList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
