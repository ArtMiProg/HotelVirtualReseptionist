package com.hotel_booking.web.controller;

import com.hotel_booking.web.model.entity.User;
import com.hotel_booking.web.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/registration")
    public String registration(Model model) {
        Integer roleId = 6;
        model.addAttribute("userForm", new User(roleId));
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Passwords don't correspond");
            return "registration";
        }
        if (!userServiceImpl.saveUser(userForm)) {
            model.addAttribute("usernameError", "User with such name already exists");
            return "registration";
        }

        return "redirect:/";
    }
}
