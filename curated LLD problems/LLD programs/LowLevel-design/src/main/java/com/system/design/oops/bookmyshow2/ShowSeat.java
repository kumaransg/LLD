package com.system.design.oops.bookmyshow2;

import lombok.Data;

@Data
public class ShowSeat extends CinemaHallSeat{
    private int showSeatId;
    private boolean isReserved;
    private double price;
}
