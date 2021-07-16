package com.system.design.lld.hotelbooking.db;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class Reservation {
    private int reservationId;
    private int userId;
    private int hotelId;
    private Date checkInDate;
    private Date checkOutDate;
    private Date createdDateTime;
}
