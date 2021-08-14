package com.mayank.fooddelivery;

import com.mayank.fooddelivery.controllers.UserController;
import com.mayank.fooddelivery.datastore.UserData;
import com.mayank.fooddelivery.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    UserController userController;

    @BeforeEach
    void setup() {
        UserService userService = new UserService(new UserData());
        userController = new UserController(userService);
    }

    @Test
    void UserFlowTest() {
        userController.addUser(TestHelper.buildUser("USER1","User Name1"));
        userController.addUser(TestHelper.buildUser("USER2","User Name2"));
        userController.addUser(TestHelper.buildUser("USER3","User Name3"));

        System.out.println(userController.getUser("USER2"));

        userController.deleteUser("USER1");

        userController.updateUser(TestHelper.buildUser("USER2", "User Name4"));
        System.out.println(userController.getUser("USER2"));
    }
}
