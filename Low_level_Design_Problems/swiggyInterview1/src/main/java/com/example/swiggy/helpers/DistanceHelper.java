package com.example.swiggy.helpers;


import com.example.swiggy.model.*;;

public class DistanceHelper {

    public static Double getHaversineDistance(Location location1, Location location2) {
        return getHaversineDistance(location1.getLatitude(),location1.getLongitude(),location2.getLatitude(),location2.getLongitude());
    }

    public static Double getHaversineDistance(Double latitude1, Double longitude1, Double latitude2, Double longitude2) {
        final int R = 6371; // Radius of the earth
        Double latDistance = toRadian(latitude2 - latitude1);
        Double lonDistance = toRadian(longitude2 - longitude1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(toRadian(latitude1))
                * Math.cos(toRadian(latitude2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        Double distance = R * c;
        return distance;
    }

    private static Double toRadian(Double value) {
        return value * Math.PI / 180;
    }
}
