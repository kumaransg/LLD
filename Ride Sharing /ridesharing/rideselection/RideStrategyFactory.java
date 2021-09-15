package com.github.akshay.ridesharing.rideselection;

import com.github.akshay.ridesharing.model.RideType;

import java.util.HashMap;
import java.util.Map;

public class RideStrategyFactory {

    private Map<RideType, RideSelectionStrategy> rideSelectionStrategyMap;

    public RideStrategyFactory() {
        rideSelectionStrategyMap = new HashMap<>();
        rideSelectionStrategyMap.put(RideType.EARLIEST_RIDE, new EarliestRideStrategy());
        rideSelectionStrategyMap.put(RideType.FASTEST_RIDE, new FastestRideStrategy());
    }

    public RideSelectionStrategy getRideStrategy(RideType rideType) {
        return rideSelectionStrategyMap.get(rideType);
    }

}
