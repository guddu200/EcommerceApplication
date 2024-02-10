package com.example.Ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ecommerceproduct")
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @GeneratedValue
    @Id
    @Column( name = "product_id")
    private  int id;

    @Column(name = "product_name")
    private String  name;

    @Column(name = "product_price")
    private int price;
    @Column(name = "product_description")
    private  String description;
//    @OneToMany(fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
