package com.github.akshay.ridesharing.rideselection;

import com.github.akshay.ridesharing.model.Ride;
import com.github.akshay.ridesharing.model.User;

import java.util.List;

public interface RideSelectionStrategy {

    Ride selectRide(List<Ride> rides, User user, int requiredSeats);

}
