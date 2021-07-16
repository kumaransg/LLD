package service;

import model.Ride;


public interface IRideService {
    public  Ride offer_ride(String user, String source, String destination, int availableseats, String vehicle, String vehicleNumber);
    public Ride select_ride(String user, String source, String destination, int seats, String strategy);
    public void end_ride(Ride ride);
}
