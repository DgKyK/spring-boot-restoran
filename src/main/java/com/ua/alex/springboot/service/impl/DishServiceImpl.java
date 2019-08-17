package com.ua.alex.springboot.service.impl;

import com.ua.alex.springboot.domain.entity.Dish;
import com.ua.alex.springboot.domain.entity.enums.Category;
import com.ua.alex.springboot.repositories.DishRepository;
import com.ua.alex.springboot.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<Dish> getAll() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.getOne(id);
    }

    @Override
    public Map<Category, List<Dish>> getSortedDishesByCategory(List<Dish> allDishes) {
        return allDishes.stream().collect(Collectors.groupingBy(Dish::getCategory));
    }
}
