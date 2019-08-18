package com.ua.alex.springboot.repositories;

import com.ua.alex.springboot.domain.entity.Order;
import com.ua.alex.springboot.domain.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getAllByStatusEquals(Status status);
    @Modifying
    @Query("update Order o set o.status = ?1 where o.id = ?2")
    void updateOrderStatus(Status status, Long id);
}
