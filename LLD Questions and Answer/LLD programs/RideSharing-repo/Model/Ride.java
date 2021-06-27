/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ridesharing.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author paragkanodia
 */
public class Ride {
    private UUID id;
    private String sharedBy;
    private List<String> selectedBy;
    private String origin;
    private String destination;
    private int availableSeats;
    private RideStatus status;
    private String vehicleNumber;
    private String vehicleModel;

    public Ride(String sharedBy, String origin, String destination, int availableSeats, String vehicleNumber, String vehicleModel) {
        this.id = UUID.randomUUID();
        this.sharedBy = sharedBy;
        this.selectedBy = new ArrayList<>();
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.status=RideStatus.ACTIVE;
        this.vehicleNumber=vehicleNumber;
        this.vehicleModel=vehicleModel;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }
    
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getSharedBy() {
        return sharedBy;
    }

    public List<String> getSelectedBy() {
        return selectedBy;
    }
    
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public RideStatus getStatus() {
        return status;
    }
    
    public void endRide()
    {
        this.status=RideStatus.END;
    }
    
    public void addPassenger(String passenger, int seats)
    {
        selectedBy.add(passenger);
        this.availableSeats-=seats;
    }

    @Override
    public String toString() {
        return "Ride details:- Ride created by "+sharedBy;
    }
    
    
}
