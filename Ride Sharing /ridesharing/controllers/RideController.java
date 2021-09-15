package com.github.akshay.ridesharing.controllers;

import com.github.akshay.ridesharing.exceptions.NoVehicleRegisteredUnderUserExceptoin;
import com.github.akshay.ridesharing.exceptions.UserNotRegisteredException;
import com.github.akshay.ridesharing.model.*;
import com.github.akshay.ridesharing.rideselection.RideSelectionStrategy;
import com.github.akshay.ridesharing.service.RideService;
import com.github.akshay.ridesharing.service.UserService;
import com.github.akshay.ridesharing.service.VehicleService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RideController {

    private UserService userService;
    private VehicleService vehicleService;
    private RideService rideService;

    public RideController(UserService userService, VehicleService vehicleService, RideService rideService) {
        this.userService = userService;
        this.vehicleService = vehicleService;
        this.rideService = rideService;
    }

    public Ride createRide(User user, Vehicle vehicle, City origin, City destination, int availableSeats, Date startTime, int durationInHours) {
        if(!userService.validateUser(user)) {
            throw new UserNotRegisteredException("user is not regitstered. user name: " + user.getName() + "user id: "+ user.getName());
        }

        if(!vehicleService.validateVehicle(vehicle)) {
            throw new NoVehicleRegisteredUnderUserExceptoin();
        }

        Ride ride = rideService.createRide(user,vehicle,origin,destination,availableSeats,startTime,durationInHours);
        return ride;
    }

    public List<Ride> offeredRides(User user) {
        return rideService.offeredRides(user);
    }

    public List<Ride> takenRides(User user) {
        return rideService.takenRides(user);
    }

    public Ride selectRide(User user, City origin, City destination,int requiredSeats, RideType rideType) {

        try {
            return rideService.selectRide(user,origin,destination,requiredSeats,rideType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return null;
    }

}
