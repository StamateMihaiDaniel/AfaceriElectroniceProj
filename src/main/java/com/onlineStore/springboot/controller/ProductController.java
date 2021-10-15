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

    @RequestMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listProducts", productService.getAllProducts());
        return "index";
    }

    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model){

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

        Product product = productService.getProductById(id);


        model.addAttribute("product", product);
        return "update_product";

    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id){

        this.productService.deleteProductById(id);
        return "redirect:/";

    }



}

