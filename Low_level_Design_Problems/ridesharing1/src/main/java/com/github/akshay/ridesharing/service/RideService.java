package com.github.akshay.ridesharing.service;

import com.github.akshay.ridesharing.model.*;
import com.github.akshay.ridesharing.rideselection.FastestRideStrategy;
import com.github.akshay.ridesharing.rideselection.RideSelectionStrategy;
import com.github.akshay.ridesharing.rideselection.RideStrategyFactory;

import javax.lang.model.util.Elements;
import java.util.*;

public class RideService {

    private Map<User, List<Ride>> offeredRideMap;
    private Map<String, List<Ride>> originDestinationRideMap;
    private RideStrategyFactory rideStrategyFactory;
    private Map<User, List<Ride>> takenRideMap;

    public RideService() {
        this.offeredRideMap = new HashMap<>();
        this.originDestinationRideMap = new HashMap<>();
        this.rideStrategyFactory = new RideStrategyFactory();
        this.takenRideMap = new HashMap<>();
    }

    public Ride createRide(User user, Vehicle vehicle, City origin, City destination, int availableSeats, Date startTime, int durationInHours) {
        // validation check if the vehicle is free

        String id = UUID.randomUUID().toString();


        Ride ride = new Ride(id,user,vehicle,origin,destination,availableSeats,startTime,durationInHours);

        offeredRideMap.computeIfAbsent(user, k->new ArrayList<>()).add(ride);

        // addin to ridemap
        String originDestinationKey = createOriginDestinationKey(origin,destination);
        originDestinationRideMap.computeIfAbsent(originDestinationKey, k -> new ArrayList<>()).add(ride);
        return ride;
    }

    public Ride selectRide(User user, City origin, City destination,int requiredSeats, RideType rideType) {
        String originDestinationKey = createOriginDestinationKey(origin,destination);

        List<Ride> rides = originDestinationRideMap.get(originDestinationKey);

        RideSelectionStrategy rideSelectionStrategy = rideStrategyFactory.getRideStrategy(rideType);

        Ride ride = rideSelectionStrategy.selectRide(rides,user,requiredSeats);

        if(ride == null) {
            throw new RuntimeException("No ride found");
        }


        takenRideMap.computeIfAbsent(user,k->new ArrayList<>()).add(ride);

        ride.setAvailableSeats(ride.getAvailableSeats()-1);
        return ride;
    }

    private String createOriginDestinationKey(City origin, City destination) {
        String o = origin.toString();
        String d = destination.toString();

        return o+":"+d;
    }

    public List<Ride> offeredRides(User user) {
        List<Ride> rides = offeredRideMap.get(user);
        return rides != null ? rides : Collections.emptyList();
    }

    public List<Ride> takenRides(User user) {
        List<Ride> rides = takenRideMap.get(user);

        return rides != null ? rides : Collections.emptyList();
    }



}
