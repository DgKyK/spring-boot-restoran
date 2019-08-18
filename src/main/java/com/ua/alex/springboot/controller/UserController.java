package com.ua.alex.springboot.controller;

import com.ua.alex.springboot.domain.entity.Dish;
import com.ua.alex.springboot.domain.entity.Order;
import com.ua.alex.springboot.domain.entity.User;
import com.ua.alex.springboot.domain.entity.enums.Category;
import com.ua.alex.springboot.service.DishService;
import com.ua.alex.springboot.service.OrderService;
import com.ua.alex.springboot.service.UserService;
import com.ua.alex.springboot.service.impl.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    private DishService dishService;
    private UserService userService;
    private OrderService orderService;

    @Autowired
    public UserController(DishService dishService, UserService userService, OrderService orderService) {
        this.dishService = dishService;
        this.userService = userService;
        this.orderService = orderService;
    }

    @RequestMapping(value = "/user")
    public String userHome(Map<String, Object> model) {
        List<Dish> dishes = dishService.getAll();
        Map<Category, List<Dish>> sortedDishesByCategory = dishService.getSortedDishesByCategory(dishes);
        model.put("meat", sortedDishesByCategory.get(Category.MEAT));
        model.put("salad", sortedDishesByCategory.get(Category.SALAD));
        model.put("deserts", sortedDishesByCategory.get(Category.DESERTS));
        model.put("drinks", sortedDishesByCategory.get(Category.DRINKS));
        return "user";
    }

    @RequestMapping("/order")
    public String createdOrder(@RequestParam String chosenMeat,
                               @RequestParam String chosenSalad,
                               @RequestParam String chosenDesert,
                               @RequestParam String chosenDrinks, Map<String, Object> model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String[] allDishesInOrder = {chosenDesert, chosenDrinks, chosenMeat, chosenSalad};

        User userThatMakesOrder = userService.findByUsername(userDetails.getUsername());
        List<Dish> listOfOrderedDishes = dishService.createListOfOrderedDishes(allDishesInOrder);

        Order order = OrderMapper.mapOrderFromStrings(listOfOrderedDishes, userThatMakesOrder.getId());

        model.put("order", order);
        orderService.saveOrder(order);

        return "order";
    }

    @RequestMapping(value = "/myorders")
    public String myOrders(@RequestParam(required = false) String orderId,
                           Map<String, Object> model) {
        if(orderId != null) {
            orderService.deleteOrder(Long.parseLong(orderId));
        }
        List<Order> approvedOrders = orderService.getAllApprovedOrders();

        model.put("approvedOrders", approvedOrders);
        return "myorders";
    }
}
