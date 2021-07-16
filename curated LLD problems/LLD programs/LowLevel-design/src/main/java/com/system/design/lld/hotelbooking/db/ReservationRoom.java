package com.system.design.lld.hotelbooking.db;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationRoom {
    private int reservationRoomId;
    private int reservationId;
    private int roomTypeId;
}
