package com.ashaipi.service;

import com.ashaipi.model.Orders;

import java.util.List;

public interface OrderService {

    List<Orders> getAllOrders();
    Orders saveOrder(Orders orders);
    Orders getOrderById(Long id);
    void deleteOrderById(Long id);

    void deleteOrderByEntity(Orders orders);


}
