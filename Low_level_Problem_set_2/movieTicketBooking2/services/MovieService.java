package movieTicketBooking2.services;

import movieTicketBooking2.model.Movie;

import java.util.List;

/**
 * @author priyamvora
 * @created 25/05/2021
 */
public class MovieService {
    private List<Movie> movieList;

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }
}
