package com.ua.alex.springboot.service.impl;

import com.ua.alex.springboot.domain.entity.Order;
import com.ua.alex.springboot.domain.entity.enums.Status;
import com.ua.alex.springboot.repositories.OrderRepository;
import com.ua.alex.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAllApprovedOrders() {
        return orderRepository.getAllByStatusEquals(Status.Approved);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Transactional
    @Override
    public void changeOrderStatusTo(Status status, long orderId) {
        orderRepository.updateOrderStatus(status, orderId);
    }
}
