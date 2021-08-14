package model;

import lombok.Data;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class Show {
    Long id;
    Screen screen;
    Theater theater;
    Movie movie;
    ConcurrentHashMap<Seat, BookingStatus> seats;
    Date timestamp;
}
