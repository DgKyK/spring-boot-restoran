package com.ua.alex.springboot.repositories;

import com.ua.alex.springboot.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
