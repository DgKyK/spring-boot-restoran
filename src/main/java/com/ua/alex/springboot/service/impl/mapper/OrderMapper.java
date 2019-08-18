package com.ua.alex.springboot.service.impl.mapper;

import com.ua.alex.springboot.domain.entity.Dish;
import com.ua.alex.springboot.domain.entity.Order;
import com.ua.alex.springboot.domain.entity.enums.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderMapper {

    public static Order mapOrderFromStrings(List<Dish> dishesInOrder, Long userId) {
        return Order.builder()
                .user_id(userId)
                .dishes(dishesInOrder)
                .status(Status.NotApproved)
                .sumOfOrder(dishesInOrder.stream().map(Dish::getCost).reduce(Integer::sum).get())
                .build();
    }
}
