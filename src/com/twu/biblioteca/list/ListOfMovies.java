package com.twu.biblioteca.list;

import com.twu.biblioteca.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hlulani on 2016/09/28.
 */
public class ListOfMovies {

    public static List<Movie> getMovies(){
        final Movie first = new Movie("Rambo 1", 1998, "Ralson", 7);
        final Movie second = new Movie("Rambo 2", 1999, "Hlulani", 8);
        final Movie third = new Movie("Rambo 3",2000,  "Ralson", 9);
        final Movie fourth = new Movie("Rambo 4", 2002, "Hlulani", 10);

        List<Movie> movies = new ArrayList<Movie>(){{
            add(first);
            add(second);
            add(third);
            add(fourth);
        }};

        return movies;
    }
}
