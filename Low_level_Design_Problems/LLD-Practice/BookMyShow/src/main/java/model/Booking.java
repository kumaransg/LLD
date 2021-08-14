package model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Booking {
    Long id;
    User user;
    Movie movie;
    Theater theater;
    Screen screen;
    List<Seat> seats;
    Date timestamp;
}
