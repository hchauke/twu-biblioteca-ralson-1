package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by hlulani on 2016/09/26.
 */
public class BookTest {

    private Book first;
    private Book second;

    @Before
    public void setUp() throws Exception {
        first = new Book("Java", "Ralson", 2014);
        second = new Book("C#", "Hlulani", 2015);
    }

    @Test
    public void testBookNotNull() throws Exception {
        Assert.assertNotNull(first);
        Assert.assertNotNull(second);
    }

    @Test
    public void testTwoDifferentBooksAreNotEqual() throws Exception {
        Assert.assertNotEquals(first, second);
    }

    @Test
    public void testTwoBooksWithSameHashCodeAreEqual() throws Exception {
        second = first;
        Assert.assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    public void testTwoBooksWithDifferentHashCodeAreEqual() throws Exception {
        Assert.assertNotEquals(first.hashCode(), second.hashCode());
    }
}
