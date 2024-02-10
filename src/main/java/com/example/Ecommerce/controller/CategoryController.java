package com.example.Ecommerce.controller;

import com.example.Ecommerce.model.Category;
import com.example.Ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")

public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //add category
    @PostMapping("/add_category")
    public Category savecategory(@RequestBody Category category){
        return categoryService.createcategory(category);
    }

    //update category by id
    @PostMapping("/update/{id}")
    public Optional<Category> updateCategory(@RequestBody Category category,@PathVariable int id) {
    Optional<Category> updatedProduct = categoryService.updatecategory(category,id);
    return updatedProduct;
    }
    //delete category by id
    @PostMapping("/delete/{id}")
    public void deletebyid(@PathVariable int id) {
        categoryService.deletecategoryById(id);;
    }

    // get all category
    @GetMapping("/get_categories")
    public List<Category>getAllCategories(){
        return categoryService.getAllCategories();
    }

    // get category by name
    @GetMapping("/findbyname/{name}")
    public Category findbyname(@PathVariable String name) {
        return categoryService.getname(name);
    }
    // get category by description
    @GetMapping("/findbydes/{des}")
    public Category findbydes(@PathVariable String des) {
        return categoryService.getdescription(des);
    }







}
