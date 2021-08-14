package movieTicketBooking.model;

import java.util.Date;
import java.util.UUID;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class Movie {
    private final String movieId;
    private final String name;
    private final String genre;
    private final String language;
    private final Date releaseDate;
    private final Integer duration;

    public Movie(String name, String genre, String language, Date releaseDate, Integer duration) {
        this.movieId = UUID.randomUUID().toString();
        this.name = name;
        this.genre = genre;
        this.language = language;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Integer getDuration() {
        return duration;
    }
}
