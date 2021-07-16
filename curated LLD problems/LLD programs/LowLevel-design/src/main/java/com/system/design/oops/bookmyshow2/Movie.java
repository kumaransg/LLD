package com.system.design.oops.bookmyshow2;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private int durationInMins;
    private String language;
    private Date releaseDate;
    private String country;
    private String genre;
    private Admin movieAddedBy;

    private List<Show> shows;
    public List<Show> getShows() {
        return Collections.emptyList();
    };
}
