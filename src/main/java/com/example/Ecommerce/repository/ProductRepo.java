package com.example.Ecommerce.repository;

import com.example.Ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT  u FROM Product u WHERE u.name=: productName")
    Product getproductname(String productName);

    @Query(value = "SELECT u FROM Product u WHERE u.price=:price")
    Product getproductprice(int price);

    @Query(value="SELECT u FROM  Product u WHERE u.description=:description")
    Product getproductdescription(String description);

}
