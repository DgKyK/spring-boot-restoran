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
import org.springframework.ui.Model;
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
                               @RequestParam String chosenDrinks, Model model) {
//        System.out.println(chosenMeat + ", " + chosenSalad + ", " + chosenDesert + ", " + chosenDrinks);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String[] allDishesInOrder = {chosenDesert, chosenDrinks, chosenMeat, chosenSalad};

        User userThatMakesOrder = userService.findByUsername(userDetails.getUsername());
        List<Dish> listOfOrderedDishes = dishService.createListOfOrderedDishes(allDishesInOrder);

        Order order = OrderMapper.mapOrderFromStrings(listOfOrderedDishes, userThatMakesOrder.getId());

        orderService.saveOrder(order);

        return "order";

    }
//    @RequestMapping("/test")
//    public String passTest(@RequestParam String chosenTest, Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//        List<Question> questList = testService.findAllByChosenTest(chosenTest);
//        Map<Integer, Answer> passedTest = AutoTestPasser.getPassedTest(questList.size());
//        Map<String, Boolean> resultTest = TestChecker.getTestReview(questList,passedTest);
//        studentSuccessService.saveCurrentResult(resultTest,chosenTest,userDetails.getUsername());
//
//        model.addAttribute("test", resultTest);
//        System.out.println(resultTest);
//        return "test";
//    }

//    @RequestMapping("/mystatistic")
//    public String statistic(Model model,
//                            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//        Page<StudentSuccess> page = studentSuccessService.findAllByUserName(userDetails.getUsername(), pageable);
//
//        model.addAttribute("page", page);
//        model.addAttribute("url", "/user/mystatistic");
//        return "mystatistic";
//    }
}
