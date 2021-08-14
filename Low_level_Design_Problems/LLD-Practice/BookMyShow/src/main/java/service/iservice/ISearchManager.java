package service.iservice;

import model.Movie;

import java.util.List;

public interface ISearchManager {
    List<Movie> getMovieByName(String searchTerm);
}
