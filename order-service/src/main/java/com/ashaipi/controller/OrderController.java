package com.ashaipi.controller;

import com.ashaipi.model.Orders;
import com.ashaipi.model.Product;
import com.ashaipi.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private final OrderServiceImpl orderServiceImpl;

    List<Product> productList;

    public OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @RequestMapping("/allproducts")
    public List<Product> getPhysicians(){
        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
                "http://peoduct-service/allproducts",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {}
        );
        productList = responseEntity.getBody();
        return productList;
    }

    @GetMapping("/allorders")
    public ResponseEntity<List<Orders>> allOrderList() {
        List<Orders> ordersList = orderServiceImpl.getAllOrders();
        return ResponseEntity.ok(ordersList);
    }

    @GetMapping("/orderlist")
    public ResponseEntity<List<Product>> orderList() {
        List<Orders> ordersList = orderServiceImpl.getAllOrders();
        // Extract the list of products from the list of orders
        List<Product> productList = new ArrayList<>();
        for (Orders order : ordersList) {
            productList.add(order.getProduct());
        }
        return ResponseEntity.ok(productList);
    }

    // orders by user id
    @GetMapping("/orderlist/{id}")
    public ResponseEntity<List<Product>> orderListById(@PathVariable("id") Long id) {
        List<Orders> ordersList = orderServiceImpl.getAllOrders();
        // Extract the list of products from the list of orders
        List<Product> productList = new ArrayList<>();
        for (Orders order : ordersList) {
            if(order.getUser().getId()==id)
                productList.add(order.getProduct());
        }
        return ResponseEntity.ok(productList);
    }

    // orders by user username
    @GetMapping("/orderlist1/{username}")
    public ResponseEntity<List<Product>> orderListById(@PathVariable("username") String username) {
        List<Orders> ordersList = orderServiceImpl.getAllOrders();
        // Extract the list of products from the list of orders
        List<Product> productList = new ArrayList<>();
        for (Orders order : ordersList) {
            if(order.getUser().getFirstName().equals(username))
                productList.add(order.getProduct());
        }
        return ResponseEntity.ok(productList);
    }


}
