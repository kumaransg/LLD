package com.system.lintcode.miniuber;

import java.util.HashMap;
import java.util.Map;

public class MiniUberImpl implements MiniUber {
    private Map<Integer, Trip> tripTable;
    private Map<Integer, Location> locTable;

    public MiniUberImpl(){
        // initialize your data structure here.
        tripTable = new HashMap<>();
        locTable = new HashMap<>();
    }
    @Override
    public Trip report(int driverId, int lat, int lng) {
        // if trip table contains driver_id, return it
        if (tripTable.containsKey(driverId)) {
            return tripTable.get(driverId);
        }

        Location loc = new Location(lat, lng);

        // report loc to location table
        locTable.put(driverId, loc);
        return null;
    }

    @Override
    public Trip request(int riderId, int lat, int lng) {
        // Write your code here
        Trip trip = new Trip(riderId, lat, lng);

        double minDist = Integer.MAX_VALUE;
        int matchedDriver = -1;
        // find the cloeset driver
        for (Integer driver_id : locTable.keySet()) {
            Location loc = locTable.get(driver_id);
            double dist = Helper.get_distance(lat, lng, loc.lat, loc.lng);
            if (dist < minDist) {
                minDist = dist;
                matchedDriver = driver_id;
            }
        }

        if (matchedDriver != -1) {
            locTable.remove(matchedDriver);
        }

        trip.driver_id = matchedDriver;
        tripTable.put(matchedDriver, trip);

        return trip;
    }
}
