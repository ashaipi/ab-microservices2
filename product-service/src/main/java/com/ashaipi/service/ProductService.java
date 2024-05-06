package com.ashaipi.service;

import com.ashaipi.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product saveProduct(Product product);
    Product getProductById(Long id);
    Product updateProduct(Product product);
    boolean deleteProductById(Long id);
}
