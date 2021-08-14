/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ridesharing.Model;

import java.util.Map;
import java.util.UUID;
import ridesharing.Database.RideManager;
import ridesharing.Exceptions.NoRideFound;

/**
 *
 * @author paragkanodia
 */
public class PreferredVehicleStrategy implements SelectionStrategy{

    @Override
    public Ride findRides(String origin, String destination, int seats, RideManager rideManager, String vehicle) {
        Map<UUID, Ride> activeRides=rideManager.getActiveRides();
        
        Ride potentialRide=null;
        
        for(Ride r: activeRides.values())
        {
            if(r.getDestination().equals(destination) && r.getOrigin().equals(origin) && r.getAvailableSeats()>=seats)
            {
                if(r.getVehicleModel().equals(vehicle))
                {
                    potentialRide=r;
                }
            }
        }
        if(potentialRide == null)
            throw new NoRideFound();
        
        return potentialRide;
        
    }
    
}
