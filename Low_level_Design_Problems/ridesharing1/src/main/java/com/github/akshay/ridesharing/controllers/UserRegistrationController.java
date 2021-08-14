package com.github.akshay.ridesharing.controllers;

import com.github.akshay.ridesharing.exceptions.UserNotRegisteredException;
import com.github.akshay.ridesharing.model.Gender;
import com.github.akshay.ridesharing.model.User;
import com.github.akshay.ridesharing.service.UserService;

public class UserRegistrationController {

    private  final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    public User createUser(String name, Gender gender, int age) {
        return userService.addUser(name,gender,age);
    }

    public boolean validateUser(User user) {
        if(userService.getUser(user.getId()) == null) {
            return false;
        }
        return true;
    }

}
