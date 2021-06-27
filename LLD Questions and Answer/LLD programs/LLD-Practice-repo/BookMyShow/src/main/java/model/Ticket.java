package model;

import lombok.Data;

import java.util.List;

@Data
public class Ticket {
    Long id;
    Show show;
    List<Seat> seats;
}
