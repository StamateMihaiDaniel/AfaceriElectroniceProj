package com.onlineStore.springboot.controller;

import com.onlineStore.springboot.model.Product;
import com.onlineStore.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    //Display list of all products\
    @RequestMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listProducts", productService.getAllProducts());
        return "index";
    }

    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model){
        //create model attribute to bind form data
        Product product = new Product();
        model.addAttribute("product", product);
        return "newProduct";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        // get employee from the service
        Product product = productService.getProductById(id);

        //set employee as a model attribute to pre-populate the form
        model.addAttribute("product", product);
        return "update_product";

    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id){
        //call delete employee method
        this.productService.deleteProductById(id);
        return "redirect:/";

    }



}

