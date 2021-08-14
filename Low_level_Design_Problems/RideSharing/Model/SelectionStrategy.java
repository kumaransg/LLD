/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ridesharing.Model;

import ridesharing.Database.RideManager;

/**
 *
 * @author paragkanodia
 */
public interface SelectionStrategy {
    public Ride findRides(String origin, String destination, int seats, RideManager rideManager, String vehicleNumber);
}
