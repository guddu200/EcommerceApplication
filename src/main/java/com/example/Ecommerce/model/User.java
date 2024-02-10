package com.example.Ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ecommerce_user")
@Getter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int Id;


    @Column(name = "user_username")
    private String username;
    @Column(name = "user_email")
    private  String email;

    @Column(name = "user_password1")
    private String password1;
    @Column(name = "user_password2")
    private String password2;

}
