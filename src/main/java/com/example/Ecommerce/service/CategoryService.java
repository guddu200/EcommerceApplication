package com.example.Ecommerce.service;

import com.example.Ecommerce.model.Category;
import com.example.Ecommerce.repository.CategoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    //add category
    public Category createcategory(Category category){
        return categoryRepo.save(category);
    }

    //update category by id
    public Optional<Category> updatecategory(Category category,int id) {
        Optional<Category>updatecategory = Optional.of(categoryRepo.saveAndFlush(category));
        int Id = category.getId();
        if(existbyid(Id)) return updatecategory;
        return null;
    }
    public boolean existbyid(int id) {
        boolean existornot = categoryRepo.existsById(id);
        return existornot;
    }

//    deleted category by id
    public void deletecategoryById(int id) {
        categoryRepo.getById(id);
    }

//    get all category
    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }


    // get category by name
    public Category getname(String name){
        return categoryRepo.categoryname(name);
    }
    // get category by description
    public  Category getdescription(String str){
        return categoryRepo.categorydescription(str);
    }







}

