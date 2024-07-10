package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.security.Principal;
import java.util.List;


@Controller
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping("/admin")
    public String adminPage(Model model, Principal principal) {

        model.addAttribute("users", userService.findAll());
        model.addAttribute("user",userService.findByUsername(principal.getName()));
        model.addAttribute("roles", roleService.getAllRoles());
        return "adminPage";

    }

    @PostMapping("/admin/new")
    public String createUser(@ModelAttribute("newUser") User user) {
        userService.registerNewAccount(user);
        return "redirect:/admin";
    }




    @PostMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @PostMapping("/admin/edit/{id}")
    public String editUser(@ModelAttribute("editUser") User user) {
        userService.editAccount(user);
        return "redirect:/admin";
    }


}
