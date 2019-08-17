package com.ua.alex.springboot.service.impl;

import com.ua.alex.springboot.domain.entity.User;
import com.ua.alex.springboot.domain.entity.enums.Role;
import com.ua.alex.springboot.repositories.UserRepository;
import com.ua.alex.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findByUsername(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean addUser(User user) {
        User userFromDb = userRepository.findByName(user.getUsername());
        if(userFromDb != null) {
            return false;
        }

        user.setAccountStatus(true);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);
        return true;
    }
}
