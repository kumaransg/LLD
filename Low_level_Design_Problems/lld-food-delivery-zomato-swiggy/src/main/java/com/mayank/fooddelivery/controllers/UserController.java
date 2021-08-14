package com.mayank.fooddelivery.controllers;

import com.mayank.fooddelivery.model.User;
import com.mayank.fooddelivery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public void addUser(final User user) {
        userService.addUser(user);
    }

    @PostMapping(value = "/user/delete")
    public void deleteUser(final String userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(value = "/user/update")
    public void updateUser(final User user) {
        userService.updateUser(user);
    }

    @GetMapping(value = "/user/{userId}")
    public User getUser(final String userId) {
        return userService.getUser(userId);
    }
}
