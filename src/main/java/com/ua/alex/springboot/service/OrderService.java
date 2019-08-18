package com.ua.alex.springboot.service;

import com.ua.alex.springboot.domain.entity.Order;
import com.ua.alex.springboot.domain.entity.enums.Status;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    void saveOrder(Order order);
    List<Order> getAllApprovedOrders();
    void deleteOrder(Long orderId);
    void changeOrderStatusTo(Status status, long orderId);
}
