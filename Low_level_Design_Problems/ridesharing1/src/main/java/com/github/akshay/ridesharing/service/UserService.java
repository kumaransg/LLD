package com.github.akshay.ridesharing.service;

import com.github.akshay.ridesharing.model.Gender;
import com.github.akshay.ridesharing.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserService {

    public Map<String,User> userMap;

    public UserService() {
        userMap = new HashMap<>();
    }

    public User addUser(String name, Gender gender, int age) {
        String id = UUID.randomUUID().toString();
        User user = new User(id,name,gender,age);
        userMap.put(user.getId(), user);
        return user;
    }

    public User getUser(String id) {
        return userMap.get(id);
    }

    public boolean validateUser(User user) {
        if(userMap.get(user.getId()) == null) {
            return false;
        }
        return true;
    }

}
