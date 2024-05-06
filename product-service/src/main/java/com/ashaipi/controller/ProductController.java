package com.ashaipi.controller;

import com.ashaipi.model.Product;
import com.ashaipi.service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
public class ProductController {

    private final ProductServiceImpl productService;

    // List all products
    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // Add new product
    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product product){
        // Validate product before saving
        if (product == null) {
            throw new IllegalArgumentException("Product must not be null");
        }
        productService.saveProduct(product);
    }

    // Delete product
    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // HTTP 204 - No Content
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
        boolean deleted = productService.deleteProductById(id);
        if (!deleted) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with ID: " + id);
        }
        return new ResponseEntity<>("The product [" + id + "] was deleted", HttpStatus.OK);
    }

    // Update existing product
    @PutMapping("/product/{id}") // Use PUT for updating resources
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {

        // get product from a database by id
        Product existingProduct = productService.getProductById(id);
        existingProduct.setId(id);
        existingProduct.setProductName(product.getProductName());
        existingProduct.setDiscount(product.getDiscount());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStockQuantity(product.getStockQuantity());
        existingProduct.setColor(product.getColor());
        existingProduct.setSize(product.getSize());
        existingProduct.setImg(product.getImg());
        existingProduct.setBarcode(product.getBarcode());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setNote(product.getNote());

        // save updated product object
        productService.updateProduct(existingProduct);

        return new ResponseEntity<>("The product [" + id + "] was updated", HttpStatus.OK);
    }

}
