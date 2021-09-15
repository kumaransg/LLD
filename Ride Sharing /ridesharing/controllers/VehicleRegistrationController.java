package com.github.akshay.ridesharing.controllers;

import com.github.akshay.ridesharing.exceptions.UserNotRegisteredException;
import com.github.akshay.ridesharing.model.User;
import com.github.akshay.ridesharing.model.Vehicle;
import com.github.akshay.ridesharing.service.UserService;
import com.github.akshay.ridesharing.service.VehicleService;

public class VehicleRegistrationController {
    private final VehicleService vehicleService;
    private final UserService userService;

    public VehicleRegistrationController(VehicleService vehicleService, UserService userService) {
        this.vehicleService = vehicleService;
        this.userService = userService;
    }

    public Vehicle createVehicle(User user, String name, String regNo) {
        if (!userService.validateUser(user)) {
            throw new UserNotRegisteredException(
                "user is not regitstered. user name: " + user.getName() + "user id: " + user.getName());
        }
        return vehicleService.createVehicle(user, name, regNo);
    }

}
