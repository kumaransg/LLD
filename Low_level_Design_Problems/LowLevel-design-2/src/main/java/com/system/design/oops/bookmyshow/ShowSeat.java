package com.system.design.oops.bookmyshow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeat {
    private String showSeatId;
    private String showId;
    private String[] seatId;
}
