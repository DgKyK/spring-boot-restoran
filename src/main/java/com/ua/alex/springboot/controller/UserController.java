package com.ua.alex.springboot.controller;

import com.ua.alex.springboot.domain.entity.Dish;
import com.ua.alex.springboot.domain.entity.enums.Category;
import com.ua.alex.springboot.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public UserController(DishService dishService) {
        this.dishService = dishService;
    }

    @RequestMapping(value = "/user")
    public String userHome(Map<String, Object> model) {

        List<Dish> dishes = dishService.getAll();
        Map<Category, List<Dish>> sortedDishesByCategory = dishService.getSortedDishesByCategory(dishes);
        //TODO add lists to the model and get it at FRONTEND
        return "user";
    }


    @RequestMapping("/order")
    public String createdOrder(@RequestParam List<String> chosenDishes, Model model) {
        System.out.println(chosenDishes);
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
