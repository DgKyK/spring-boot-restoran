package com.ua.alex.springboot.service;

import com.ua.alex.springboot.domain.entity.User;

import java.util.List;

public interface UserService {
    User findByUsername(String name);
    void save(User user);
    List<User> findAll();
    boolean addUser(User user);
}
