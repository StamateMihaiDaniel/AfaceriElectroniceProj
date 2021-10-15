package com.onlineStore.springboot.service;

import com.onlineStore.springboot.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void saveProduct(Product product);
    Product getProductById(long id);
    void deleteProductById(long id);

}
