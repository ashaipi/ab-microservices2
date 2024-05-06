package com.ashaipi.service;

import com.ashaipi.model.Orders;
import com.ashaipi.model.Product;
import com.ashaipi.repository.OrderRepository;
import com.ashaipi.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductRepository productRepository){
        super();
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    // Implement methods for managing orders

    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Orders saveOrder(Orders orders) {
        return orderRepository.save(orders);
    }

    @Override
    public void deleteOrderById(Long id){
        orderRepository.deleteById(id);
    }

    @Override
    public Orders getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public void deleteOrderByEntity(Orders orders){
        orderRepository.delete(orders);
    }

    public List<Product> findJoinProductsUserAddToCart(@Param("userId") Long userId){
        return orderRepository.findProductsByUserId(userId);
    }

    public void deleteOrderFromCart(@Param("oId") Long orderId){
        orderRepository.deleteOrderFromCart(orderId);
    }

    public int getTotalInBag() {
        // Retrieve cart items from repository or service
        List<Orders> orders = orderRepository.findAll(); // Adjust this according to your actual implementation

        // Check if cartItems is null or empty
        if (orders.isEmpty()) {
            return 0; // Return 0 if there are no cart items
        }
        return orders.size();
    }

}