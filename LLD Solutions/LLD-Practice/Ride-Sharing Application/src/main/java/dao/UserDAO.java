package dao;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDAO implements IUserDAO{
     private Map<String, User> userMapper = new HashMap<String, User>();

    public User addUser(String name, String gender, Integer age) {
        User newUser= new User(name, gender,age);
        userMapper.put(name, newUser);
        return newUser;
    }

    public User getUser(String name){
        return userMapper.getOrDefault(name,null);
    }
}
