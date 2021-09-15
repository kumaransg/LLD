package com.system.lintcode.miniuber;

public interface MiniUber {
    Trip report( int driverId, int lat, int lng);
    Trip request( int riderId, int lat, int lng);
}
