package com.example.Ecommerce.controller;

import com.example.Ecommerce.model.User;
import com.example.Ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {



    @Autowired
    UserService userservice;

    @PostMapping("/registration")
    public User register(@RequestBody User user){
        User res=userservice.register(user);
        return res;

    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user){
        String username=user.getUsername();
        String password=user.getPassword1();

        //System.out.println(user.getPassword());
        String result=userservice.userLogin(username,password);

        return result;
    }

}
