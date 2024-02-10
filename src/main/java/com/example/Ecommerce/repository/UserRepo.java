package com.example.Ecommerce.repository;

import com.example.Ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.username = :username")
    User getUserByUsername(String username);

    @Query(value ="SELECT u FROM User u WHERE u.id = :id")
    Optional<User>getUserById(int id);

}
