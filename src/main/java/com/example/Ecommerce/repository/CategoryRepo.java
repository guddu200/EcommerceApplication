package com.example.Ecommerce.repository;

import com.example.Ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo  extends JpaRepository<Category,Integer> {

    @Query(value = "SELECT  u FROM Category u WHERE u.name =:name")
     Category categoryname(String name);

    @Query(value = "SELECT u FROM Category u WHERE u.description=:description")
     Category categorydescription(String description);
}
