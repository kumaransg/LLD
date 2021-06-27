package model;

import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;

@Data
public class Seatlock{
    Long id;
    ConcurrentHashMap<Show,Seat> lockedSeats;
}
