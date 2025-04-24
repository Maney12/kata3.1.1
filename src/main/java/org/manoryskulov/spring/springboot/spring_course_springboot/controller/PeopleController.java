package org.manoryskulov.spring.springboot.spring_course_springboot.controller;

import org.manoryskulov.spring.springboot.spring_course_springboot.model.User;
import org.manoryskulov.spring.springboot.spring_course_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/users")
public class PeopleController {
    final
    UserService service;

    @Autowired
    public PeopleController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String listUsers(Model model) {
        model.addAttribute("users", service.listUsers());
        return "users";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String firstName,
                          @RequestParam String lastName,
                          @RequestParam String email) {
        User user = new User(firstName, lastName, email);
        service.add(user);
        return "redirect:/users/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        service.deleteUserById(id);
        return "redirect:/users/";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam Long id, Model model) {
        User user = service.findById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam Long id,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String email) {
        User user = new User(id, firstName, lastName, email);
        service.updateUser(user);
        return "redirect:/users/";
    }

}