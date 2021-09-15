package com.github.akshay.ridesharing;


import com.github.akshay.ridesharing.controllers.RideController;
import com.github.akshay.ridesharing.controllers.UserRegistrationController;
import com.github.akshay.ridesharing.controllers.VehicleRegistrationController;
import com.github.akshay.ridesharing.model.*;
import com.github.akshay.ridesharing.service.RideService;
import com.github.akshay.ridesharing.service.UserService;
import com.github.akshay.ridesharing.service.VehicleService;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RideSharingAppTest {

    @Test
    public void RideSharingAppTest() {
        UserService userService = new UserService();
        VehicleService vehicleService = new VehicleService();
        RideService rideService = new RideService();

        UserRegistrationController userRegistrationController = new UserRegistrationController(userService);
        VehicleRegistrationController vehicleRegistrationController = new VehicleRegistrationController(vehicleService,userService);
        RideController rideController = new RideController(userService,vehicleService,rideService);


        User rohan = userRegistrationController.createUser("Rohan", Gender.MALE, 36);
        User shashank = userRegistrationController.createUser("Shashank", Gender.MALE, 29);
        User nandini = userRegistrationController.createUser("Nandini", Gender.FEMALE,29);
        User shipra = userRegistrationController.createUser("Shipra", Gender.FEMALE, 27);
        User gaurav = userRegistrationController.createUser("Gaurav",Gender.MALE,29);


        Vehicle rohanSwiftVehicle = vehicleRegistrationController.createVehicle(rohan,"Swift","KA-01-12345");
        Vehicle shashankBalenoVehicle = vehicleRegistrationController.createVehicle(shashank,"Baleno", "TS-05-62395");
        Vehicle shipraPoloVehicle = vehicleRegistrationController.createVehicle(shipra,"Polo", "KA-05-41491");
        Vehicle shipraScootVehicle = vehicleRegistrationController.createVehicle(shipra,"Scooty", "KA-12-12332");



        Ride rohanSwiftHydBangRide = rideController.createRide(rohan, rohanSwiftVehicle, City.HYDERABAD,City.BANGALORE,1,new Date(2019, 1, 25,8,0),13);
        Ride shipraScootyBanMysRide = rideController.createRide(shipra, shipraScootVehicle, City.BANGALORE,City.MYSORE,1,new Date(2019, 1, 29,18,0),10);
        Ride shipraPoloBangMysRide = rideController.createRide(shipra, shipraPoloVehicle, City.BANGALORE,City.MYSORE,2,new Date(2019, 1, 30,8,0),4);
        Ride shashankBalenoHydBangRide = rideController.createRide(shashank, shashankBalenoVehicle, City.HYDERABAD,City.BANGALORE,2,new Date(2019, 1, 27,10,0),14);


        Ride nandhiniRideBangMys = rideController.selectRide(nandini,City.BANGALORE,City.MYSORE,1,RideType.FASTEST_RIDE);
        printRideDetails(nandini,nandhiniRideBangMys);

        Ride gauravRideBangMys = rideController.selectRide(gaurav,City.BANGALORE,City.MYSORE,1,RideType.EARLIEST_RIDE);
        printRideDetails(gaurav,gauravRideBangMys);

        Ride shashankRideMumBang = rideController.selectRide(shashank,City.MUMBAI, City.BANGALORE,1,RideType.FASTEST_RIDE);
        printRideDetails(shashank,shashankRideMumBang);

        Ride rohanHydBangRide = rideController.selectRide(rohan,City.HYDERABAD, City.BANGALORE,1,RideType.FASTEST_RIDE);
        printRideDetails(rohan,rohanHydBangRide);


        List<Ride> nandiniRidesTaken = rideController.takenRides(nandini);
        List<Ride> nandiniRidesOffered = rideController.offeredRides(nandini);
        System.out.println("nandini: "+ nandiniRidesTaken.size() + "Taken, " + nandiniRidesOffered.size() + " Offered");

        List<Ride> rohanRidesTaken = rideController.takenRides(rohan);
        List<Ride> rohanRidesOffered = rideController.offeredRides(rohan);
        System.out.println("rohan: "+ rohanRidesTaken.size() + "Taken, " + rohanRidesOffered.size() + " Offered");

        List<Ride> shashankRidesTaken = rideController.takenRides(shashank);
        List<Ride> shashankRidesOffered = rideController.offeredRides(shashank);
        System.out.println("shashank: "+ shashankRidesTaken.size() + "Taken, " + shashankRidesOffered.size() + " Offered");

        List<Ride> gauravRidesTaken = rideController.takenRides(gaurav);
        List<Ride> gauravRidesOffered = rideController.offeredRides(gaurav);
        System.out.println("gaurav: "+ gauravRidesTaken.size() + "Taken, " + gauravRidesOffered.size() + " Offered");




    }

    public void printRideDetails(User user,Ride ride) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User: ").append(user.getName());
        if(ride == null) {
            stringBuilder.append(". No ride found");
            System.out.println(stringBuilder.toString());
            return;
        }
        stringBuilder.append(". VehicleOwner: ").append(ride.getUser().getName());
        stringBuilder.append(". Vehicle: ").append(ride.getVehicle().getName());
        stringBuilder.append(". Origin: ").append(ride.getOrigin());
        stringBuilder.append(". Destination: ").append(ride.getDestination());
        stringBuilder.append(". StartTime: ").append(ride.getStartTime());
        stringBuilder.append(". Duration: ").append(ride.getDurationInHours());
        System.out.println(stringBuilder.toString());
    }
}