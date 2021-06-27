package ParkingLot.services;

import ParkingLot.domain.Parking.ParkingType;
import ParkingLot.domain.Vehicle.Vehicle;

import java.time.Instant;

public class ParkingRequest {
    Vehicle vehicle;
    Instant time;
    ParkingType parkingNeeds;
    RequestType requestType;
}
