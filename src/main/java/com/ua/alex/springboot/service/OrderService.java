package com.ua.alex.springboot.service;

import com.ua.alex.springboot.domain.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    void saveOrder(Order order);
}
