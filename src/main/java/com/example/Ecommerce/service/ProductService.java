package com.example.Ecommerce.service;

import com.example.Ecommerce.exceptionHandling.IdException;
import com.example.Ecommerce.exceptionHandling.ProductException;
import com.example.Ecommerce.model.Category;
import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.repository.CategoryRepo;
import com.example.Ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    private  final CategoryRepo categoryRepo;

    @Autowired
    public ProductService (ProductRepo productRepo,CategoryRepo categoryRepo){
        this.productRepo=productRepo;
        this.categoryRepo=categoryRepo;
    }


    //add product
    public Product saveProduct(Product product){
        return productRepo.save(product);
    }


    // Link product with category
    public Product linkProductWithCategory(int category_id, Product product1) throws ProductException {
        Category category = categoryRepo.findById(category_id).get();
        if (category == null) {
            throw new ProductException("Category not found");
        }

        product1.setCategory(category);
        Product savedProduct = productRepo.save(product1);
        Product product = new Product();
        product.setId(savedProduct.getId());
        product.setName(savedProduct.getName());
        product.setPrice(savedProduct.getPrice());
        product.setCategory(savedProduct.getCategory());
        product.setDescription(savedProduct.getDescription());
        return product;
    }

    // update product by id
    public boolean existsbyid(int id) {
        return productRepo.existsById(id);
    }

    public Product updatebyid(int id, Product updating) throws IdException {
        if (!productRepo.existsById(id)) {
            throw new IdException();
        }
        Product existing = productRepo.findById(id).get();
        if (updating.getName() != null) {
            existing.setName(updating.getName());
        }
        if (updating.getDescription() != null) {
            existing.setDescription(updating.getDescription());
        }

        return saveProduct(existing);


    }
    // delete product by id
    public void deleteProductById(int id) {
        productRepo.deleteById(id);
    }

    // get all products
    public List<Product> getallproducts() {
        return productRepo.findAll();
    }

    //get product by name
    public Product getproductname(String name){
        return productRepo.getproductname(name);
    }
    //get product by price
    public  Product getproductprice(int price){
        return productRepo.getproductprice(price);
    }
    //get product by description
    public Product getproductdescription(String str){
        return productRepo.getproductdescription(str);
    }






}
