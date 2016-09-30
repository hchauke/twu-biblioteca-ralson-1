package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by hlulani on 2016/09/28.
 */
public class MovieTest {

    private Movie first;
    private Movie second;

    @Before
    public void setUp() throws Exception {
        first = new Movie("Die hard", 2016, "Ralson", 9);
        second = new Movie("Die another day", 2016, "Hlulani", 10);
    }

    @Test
    public void testMovieNotEqualToNull() throws Exception {
        Assert.assertNotNull(first);
        Assert.assertNotNull(second);
    }

    @Test
    public void testDifferentMoviesAreNotEqual() throws Exception {
        Assert.assertNotEquals(first, second);

    }

    @Test
    public void testMoviesWithSameHashCodeAreEqual() throws Exception {
        second = first;
        Assert.assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    public void testMoviesWithDifferetHashCodeAreNotEqual() throws Exception {
        Assert.assertNotEquals(first.hashCode(), second.hashCode());

    }
}
