package com.example.Ecommerce.service;

import com.example.Ecommerce.model.User;
import com.example.Ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

        private UserRepo userrepository;
        private  TokenService tokenservice;
        @Autowired
        public UserService(UserRepo userRepoObj, TokenService tokenservice) {
            this.userrepository = userRepoObj;
            this.tokenservice = tokenservice;
        }


    public User register(User user){
            User saveall=userrepository.save(user);
        System.out.println("register successful");
            return saveall;
    }

        public String userLogin(String username,String password){
            boolean foundUsers = existByEmail(username);
            if(foundUsers) {
                User userObj = userrepository.getUserByUsername(username);
                if(userObj.getPassword1().equals(password) || userObj.getPassword2().equals(password)){
                  //  System.out.println(tokenservice.createToken(userObj.getUserId());
                    return "{" +
                            "\"message\":"+"Successfully logged in\",\n"+
                            "\"data\":"+userObj+",\n"+
                            "\"Email: "+ userObj.getEmail()+"\n"+
                            "\"token: "+ tokenservice.createTokenFunction(userObj.getId())+
                            "\""+
                            "}";
                }
            }

            return "{" +
                    "\"message\":"+"Authentication failed\",\n"+
                    "}";
        }
        public Boolean existByEmail(String email){
            Optional<User> usersObj = Optional.ofNullable(userrepository.getUserByUsername(email));
            //List<User> usersObj= userRepoObj.getUserByUsername(email);
            if(!usersObj.isEmpty()){
                return true;
            }
            return false;
        }
    }

