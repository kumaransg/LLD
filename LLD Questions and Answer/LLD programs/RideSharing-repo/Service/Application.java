/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ridesharing.Service;

import java.util.Collection;
import java.util.List;
import ridesharing.Database.RideManager;
import ridesharing.Database.UserManager;
import ridesharing.Exceptions.InvalidVehicle;
import ridesharing.Exceptions.NoRideFound;
import ridesharing.Model.MostVacantStrategy;
import ridesharing.Model.PreferredVehicleStrategy;
import ridesharing.Model.Ride;
import ridesharing.Model.SelectionStrategyType;
import ridesharing.Model.User;
import ridesharing.Model.Vehicle;

/**
 *
 * @author paragkanodia
 */
public class Application {
    private RideManager rideManager;
    private UserManager userManager;

    public Application() {
        this.rideManager=new RideManager();
        this.userManager=new UserManager();
    }
    
    public void add_user(String name, char gender, int age)
    {
        try{
            User user= new User(name,gender, age);
            userManager.addUser(user);
            System.out.println("User "+name +" added");
        }catch(RuntimeException e)
        {
            System.out.println(e);
        }
    }
    
    public void add_vehicle(String userName, String model, String vehicleNumber)
    {
        try{
            Vehicle vehicle = new Vehicle(userName, model, vehicleNumber);
            User user= userManager.getUser(userName);
            user.addVehicle(vehicle);
            System.out.println("Vehicle "+vehicleNumber+" for user "+userName+" added");
        }catch(RuntimeException e)
        {
            System.out.println(e);
        }
        
        
    }
    
    public void offer_ride(String userName,String origin, int availableSeats, String vehicleModel ,String vehicleNumber, String destination)
    {
        try
        {
            Ride newRide= new Ride(userName, origin, destination, availableSeats, vehicleNumber,vehicleModel );
            User user=userManager.getUser(userName);

            if(!user.checkVehicle(vehicleNumber))
                throw new InvalidVehicle();

            rideManager.addOfferRide(newRide,user.getName());
            //user.addSharedRide(newRide);
            System.out.println("Ride offered by "+userName+" from "+origin+" to "+destination+". Available Seats "+
                    availableSeats+" vehicle "+vehicleModel+ " vehicleNumber "+vehicleNumber);
        }catch(RuntimeException e)
        {
            System.out.println(e);
        }
                
        
    }
    
    public Ride select_ride(String userName,String origin, String destination, int seats, SelectionStrategyType strategy, String vehicle)
    {
        Ride ride=null;
        try{
            if(strategy.equals(SelectionStrategyType.PREFFERED))
            {
                PreferredVehicleStrategy st=new PreferredVehicleStrategy();
                ride=st.findRides(origin, destination, seats, rideManager,vehicle );
            }
            else if(strategy.equals(SelectionStrategyType.MOST_VACANT))
            {
                MostVacantStrategy st=new MostVacantStrategy();
                ride= st.findRides(origin, destination, seats, rideManager,vehicle);
            }
            if(ride!=null)
            {
                ride.addPassenger(userName, seats);
            }
            else
                throw new NoRideFound();
            System.out.println(ride.toString());
        }catch(RuntimeException e)
        {
            System.out.println(e);
        }
        return ride;
    }

    
    public void end_ride(String userName,String origin, int availableSeats, String vehicleModel ,String vehicleNumber, String destination)
    {
        Ride ride=rideManager.endRide(vehicleNumber);
        ride.endRide();
        String sharedBy=ride.getSharedBy();
        List<String> passengers=ride.getSelectedBy();
        
        User user=userManager.getUser(sharedBy);
        user.addSharedRide(ride);
        
        for(String s: passengers)
        {
            user=userManager.getUser(s);
            user.addConsumedRide(ride);
        }
    }
    
    public void print_ride_status()
    {
        Collection<User> users=userManager.getUsers();
        users.forEach((user) -> {
            System.out.println(user.getName()+": "+user.getConsumedRides().size()+" Taken "+user.getSharedRides().size()+" Offered");
        });
    }
    
}
