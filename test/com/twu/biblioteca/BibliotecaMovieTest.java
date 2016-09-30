package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.Biblioteca.getBasketMovies;

/**
 * Created by hlulani on 2016/09/29.
 */
public class BibliotecaMovieTest {


    Movie first;
    Movie second;
    Movie third;
    Movie fourth;

    List<Movie> movies;

    Biblioteca biblioteca = new Biblioteca();

    @Before
    public void setUp() throws Exception {
        biblioteca = new Biblioteca();

        first = new Movie("Rambo 1", 1998, "Ralson", 7);
        second = new Movie("Rambo 2", 1999, "Hlulani", 8);
        third = new Movie("Rambo 3",2000,  "Ralson", 9);
        fourth = new Movie("Rambo 4", 2002, "Hlulani", 10);

        movies = new ArrayList<Movie>();
        movies.add(first);
        movies.add(second);
        movies.add(third);
        movies.add(fourth);
    }

    @Test
    public void testGetMoviesHeaderColumns() throws Exception {
        String header = "" +
                "+------+-----------+-----------+--------------+----------+" + "\n"
                + "|number|Name       | year      | Director     | Ratings  |" + "\n"
                + "+------+-----------+-----------+--------------+----------+";
        Assert.assertEquals(header, biblioteca.getMovieListHeader());
    }

    @Test
    public void testGetLeftContentAlignerForMovie() throws Exception {
        Assert.assertEquals("| %-4s | %-9s |%-9s | %-13s | %-5s %n", biblioteca.getMovieContentAligner());

    }

    @Test
    public void testValidMenuOption() throws Exception {
        Assert.assertEquals(biblioteca.listMovies(2), true);
    }

    @Test
    public void testGetListOfMovies() throws Exception {

        List<Movie> movieList = biblioteca.getAllMovies();
        Assert.assertEquals(movies, movieList);

        for (int i = 0; i < movies.size(); i++) {
            Assert.assertEquals(movies.get(i).getName(), movieList.get(i).getName());
            Assert.assertEquals(movies.get(i).getYear(), movieList.get(i).getYear());
            Assert.assertEquals(movies.get(i).getDirector(), movieList.get(i).getDirector());
            Assert.assertEquals(movies.get(i).getRating(), movieList.get(i).getRating());
        }

    }

    @Test
    public void testAddAndGetMovieFromBaset() throws Exception {

        Assert.assertEquals(1, getBasketMovies().size());

        biblioteca.addMovieToBasket(movies.get(0));

        Assert.assertEquals(2, getBasketMovies().size());

    }

    @Test
    public void testCheckOutAndGetMovieFromBasket() throws Exception {
        Assert.assertEquals(0, getBasketMovies().size());

        biblioteca.checkOutMovie(1);

        Assert.assertEquals(1, getBasketMovies().size());
    }

}
