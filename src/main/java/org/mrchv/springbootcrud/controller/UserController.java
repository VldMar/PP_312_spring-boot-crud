package org.mrchv.springbootcrud.controller;

import org.mrchv.springbootcrud.model.User;
import org.mrchv.springbootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String showAllUsers(ModelMap model) {
        model.addAttribute("users", userService.findAllUsers());
        return "users/all-users";
    }

    @GetMapping("/add")
    public String showFormForCreateUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "users/add-user";
    }

    @GetMapping("/update")
    public String showFormForUpdateUser(@RequestParam("id") Long userId, Model model) {
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "users/update-user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/remove")
    public String removeUser(@RequestParam("id") Long userId) {
        userService.removeUserById(userId);
        return "redirect:/";
    }
}
