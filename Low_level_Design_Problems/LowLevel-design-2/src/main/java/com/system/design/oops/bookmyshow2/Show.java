package com.system.design.oops.bookmyshow2;

import lombok.Data;

import java.util.Date;

@Data
public class Show {
    private int showId;
    private Date createdOn;
    private Date startTime;
    private Date endTime;
    private CinemaHall playedAt;
    private Movie movie;
}
