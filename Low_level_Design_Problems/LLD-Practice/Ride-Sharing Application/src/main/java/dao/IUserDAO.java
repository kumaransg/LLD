package dao;

import model.User;

public interface IUserDAO {
    User addUser(String name, String gender, Integer age);
    User getUser(String name);
}
