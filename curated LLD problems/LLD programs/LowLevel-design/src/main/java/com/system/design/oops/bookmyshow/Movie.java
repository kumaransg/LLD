package com.system.design.oops.bookmyshow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private String movieId;
    private String name;
    private MovieType movieType;
    private Genre genre;
    private String directorName;
    private String duration;
}
