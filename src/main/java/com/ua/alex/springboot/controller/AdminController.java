package com.ua.alex.springboot.controller;

import com.ua.alex.springboot.domain.entity.Order;
import com.ua.alex.springboot.domain.entity.User;
import com.ua.alex.springboot.domain.entity.enums.Role;
import com.ua.alex.springboot.domain.entity.enums.Status;
import com.ua.alex.springboot.service.OrderService;
import com.ua.alex.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/admin")
@Controller
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;



    @RequestMapping(value = "/admin")
    public String adminHome(Model model) {

        model.addAttribute("users", userService.findAll());

        return "admin";
    }

    @RequestMapping(value = "/allorders")
    public String orders(Model model) {
        List<Order> allOrders = orderService.getAllOrders();

        model.addAttribute("allOrders", allOrders);

        return "allorders";
    }


    @PostMapping("/approveorder")
    public String approveOrder(@RequestParam long orderId) {
        orderService.changeOrderStatusTo(Status.Approved, orderId);
        return "redirect:/admin/allorders";
    }

    @PostMapping("/deleteorder")
    public String declineOrder(@RequestParam long orderId) {
        orderService.deleteOrder(orderId);
        return "redirect:/admin/allorders";
    }

    @GetMapping("/admin/{user}")
    public String editUser(@PathVariable User user, Model model) {
//        System.out.println(user);
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "editUser";
    }

    @PostMapping
    public String userSave(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("role") String role,
            @RequestParam("userId") User user) {
        user.setName(username);
        user.setEmail(email);
        user.setRole(Role.valueOf(role));

        userService.save(user);
        return "/admin/admin";
    }
}

