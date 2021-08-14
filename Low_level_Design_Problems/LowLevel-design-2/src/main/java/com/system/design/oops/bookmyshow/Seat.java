package com.system.design.oops.bookmyshow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    private String seatId;
    private String seatNumber;
    private SeatType seatType;
}
