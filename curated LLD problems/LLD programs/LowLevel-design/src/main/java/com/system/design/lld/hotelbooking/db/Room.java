package com.system.design.lld.hotelbooking.db;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Room {
    private int roomId;
    private int hotelId;
    private int roomNumber;
    private String roomName;
    private int roomTypeId;
    private int roomPrice;
    private int capacity;
}
