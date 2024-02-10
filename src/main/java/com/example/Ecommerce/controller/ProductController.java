package com.example.Ecommerce.controller;

import com.example.Ecommerce.exceptionHandling.IdException;
import com.example.Ecommerce.exceptionHandling.ProductException;
import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    ProductService productServ;

    //add product
    @PostMapping("/add_product")
    @ResponseStatus(HttpStatus.OK)
    public Product save(@RequestBody Product product){
        System.out.println("Check");
        return productServ.saveProduct(product);
    }

    // link product with category
    @PostMapping("/product-with-category")
    public Product linkProdWithCategory(@PathVariable int id, @RequestBody Product product) throws ProductException {
        Product linkProduct=productServ.saveProduct(product);
        return linkProduct;
    }

    //delete product by id
    @PostMapping("/delete/{id}")
    public void deletebyid(@PathVariable int id) {
        productServ.deleteProductById(id);
    }


    //update product by id
    @PostMapping("/update/{id}")
    public  Product updateproduct(@PathVariable int id,Product product) throws IdException {
        return productServ.updatebyid(id,product);
    }

    // get all product
    @GetMapping("/get_product")
    public List<Product> getallproduct() {
        List<Product> product = productServ.getallproducts();
        return product;
    }

    // get product by name
    @GetMapping("/findbyname/{name}")
    public Product findbyname(@PathVariable String name) {
        return productServ.getproductname(name);
    }
    // get product by description
    @GetMapping("/findbydes/{des}")
    public Product findbydes(@PathVariable String des) {
        return productServ.getproductdescription(des);
    }
    // get product by price
    @GetMapping("/findbyprice/{price}")
    public Product findbyprice(@PathVariable int price) {
        return productServ.getproductprice(price);
    }





}
