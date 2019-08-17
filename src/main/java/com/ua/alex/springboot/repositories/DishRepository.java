package com.ua.alex.springboot.repositories;

import com.ua.alex.springboot.domain.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
