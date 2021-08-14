package com.github.akshay.ridesharing.rideselection;

import com.github.akshay.ridesharing.model.Ride;
import com.github.akshay.ridesharing.model.User;

import java.util.List;
import java.util.Optional;

public class FastestRideStrategy implements RideSelectionStrategy {
    @Override
    public Ride selectRide(List<Ride> rides, User user, int requiredSeats) {
        if(rides == null || rides.size() == 0) {
            return null;
        }

        Optional<Ride> optionalRide = rides.stream()
                                            .filter(ride -> !ride.getUser().getId().equals(user.getId()))
                                            .filter(ride->ride.getAvailableSeats() >= requiredSeats)
                                            .min((a,b) -> a.getDurationInHours() - b.getDurationInHours());

        if(optionalRide.isEmpty()) {
            return null;
        }

        return optionalRide.get();

    }
}
