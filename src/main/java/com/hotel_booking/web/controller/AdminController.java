package com.hotel_booking.web.controller;

import com.hotel_booking.web.model.entity.User;
import com.hotel_booking.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/admin")
    public String userList(Model model) {
        List<User> userList = userService.getAll();

        model.addAttribute("allUsers", userList);
        return "admin";
    }

    @PostMapping("/admin")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Integer id,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(id);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/get/{userId}")
    public String  getUser(@PathVariable("userId") Integer userId, Model model) {
        model.addAttribute("allUsers", userService.userGetList(userId));
        return "admin";
    }
}
