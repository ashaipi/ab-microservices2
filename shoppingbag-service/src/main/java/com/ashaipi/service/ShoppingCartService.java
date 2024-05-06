package com.ashaipi.service;

import com.ashaipi.repository.ShoppingCartRepository;
import com.ashaipi.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public List<ShoppingCart> getAllItemsInCart() {
        return shoppingCartRepository.findAll();
    }

    public void addToCart(String productName, String description, double price, String img) {
        ShoppingCart cart = new ShoppingCart();
        cart.setProductName(productName);
        cart.setDescription(description);
        cart.setPrice(price);
        cart.setImg(img);
        shoppingCartRepository.save(cart);
    }

    public int getTotalInCart() {
        // Retrieve cart items from repository or service
        List<ShoppingCart> itemsInCart = shoppingCartRepository.findAll(); // Adjust this according to your actual implementation

        // Check if cartItems is null or empty
        if (itemsInCart == null || itemsInCart.isEmpty()) {
            return 0; // Return 0 if there are no cart items
        }

        // Calculate the total count of items in the cart
        /*
        int totalCount = 0;
        for (ShoppingCart item: cart) {
            totalCount += item.getQuantity(); // Assuming each cart item has a quantity field
        }
        */

        int totalCount = itemsInCart.size();

        return totalCount;
    }

    public double getTotalPriceInCart() {
        // Retrieve cart items from repository or service
        List<ShoppingCart> itemsInCart = shoppingCartRepository.findAll(); // Adjust this according to your actual implementation

        // Check if cartItems is null or empty
        if (itemsInCart == null || itemsInCart.isEmpty()) {
            return 0; // Return 0 if there are no cart items
        }

        double totalprice = 0.0;
        for (ShoppingCart item: itemsInCart) {
            totalprice += item.getPrice();
        }

        return totalprice;
    }

    public void deleteItemInCartById(Long id) {
        shoppingCartRepository.deleteById(id);
    }
}
