package com.github.akshay.ridesharing.rideselection;

import com.github.akshay.ridesharing.model.Ride;
import com.github.akshay.ridesharing.model.User;

import java.util.*;

public class EarliestRideStrategy implements RideSelectionStrategy {

    @Override
    public Ride selectRide(List<Ride> rides, User user, int requiredSeats) {
        if(rides == null || rides.size() == 0) return null;

        Optional<Ride> optionalRide = rides.stream()
                .filter(ride -> !ride.getUser().getId().equals(user.getId()))
                .filter(ride -> ride.getAvailableSeats() >= requiredSeats)
                    .min(this::getEarliestTime);

        return optionalRide.get();

    }

    private int getEarliestTime(Ride ride1, Ride ride2) {
        Date ride1EarliestDate = addHoursToDate(ride1.getStartTime(), ride1.getDurationInHours());
        Date ride2EarliestDate = addHoursToDate(ride2.getStartTime(), ride2.getDurationInHours());

        if(ride1EarliestDate.before(ride2EarliestDate)) {
            return -1;
        } else {
            return 1;
        }
    }

    private Date addHoursToDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }
}
