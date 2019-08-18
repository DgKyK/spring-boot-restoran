package com.ua.alex.springboot.service;

import com.ua.alex.springboot.domain.entity.Dish;
import com.ua.alex.springboot.domain.entity.enums.Category;

import java.util.List;
import java.util.Map;

public interface DishService {
    List<Dish> getAll();
    Dish findById(Long id);
    Map<Category, List<Dish>> getSortedDishesByCategory(List<Dish> AllDishes);
    List<Dish> createListOfOrderedDishes(String[] orderedDishes);
}
