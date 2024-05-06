package com.ashaipi.service;

import com.ashaipi.model.Product;
import com.ashaipi.repository.ProductRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

        private final ProductRepository productRepository;

        public ProductServiceImpl(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        @Override
        public List<Product> getAllProducts() {
            return productRepository.findAll();
        }

        @Override
        public Product saveProduct(Product product) {
            return productRepository.save(product);
        }

        @Override
        public Product getProductById(Long id) {
            return productRepository.findById(id).get();
        }


        @Override
        public Product updateProduct(Product product) {
            // Check if the product exists before attempting to update
            if (product == null || product.getId() == null) {
                throw new IllegalArgumentException("Product or Product ID must not be null");
            }

            if (!productRepository.existsById(product.getId())) {
                throw new EmptyResultDataAccessException("Product not found with ID: " + product.getId(), 1);
            }

            // If the product exists, update it
            return productRepository.save(product); // `save` will update an existing product
        }

        @Override
        public boolean deleteProductById(Long id) {
            try {
                productRepository.deleteById(id);
                return true; // Indicates successful deletion
            } catch (EmptyResultDataAccessException ex) {
                // Thrown when trying to delete a non-existent ID
                return false; // Indicates failure to delete because ID didn't exist
            } catch (Exception ex) {
                // Handle other exceptions that might occur during deletion
                throw new RuntimeException("Error deleting product with ID: " + id, ex);
            }
        }
}