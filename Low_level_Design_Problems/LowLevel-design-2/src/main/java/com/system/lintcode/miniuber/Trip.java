package com.system.lintcode.miniuber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Trip {
    public int id; // trip's id, primary key
    public int driver_id, rider_id; // foreign key
    public double lat, lng; // pick up location

    public Trip(int riderId, int lat, int lng) {
    }
}
