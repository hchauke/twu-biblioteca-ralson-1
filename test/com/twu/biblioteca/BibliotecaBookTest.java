package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.Biblioteca.getBasketBooks;
import static com.twu.biblioteca.Biblioteca.getLibraryBooks;

/**
 * Created by hlulani on 2016/09/26.
 */

public class BibliotecaBookTest {

    Biblioteca biblioteca;

    Book first;
    Book second;
    Book third;
    Book fourth;
    List<Book> books;

    @Before
    public void setUp() throws Exception {
        biblioteca = new Biblioteca();

        first = new Book("Java", "Ralson", 2014);
        second = new Book("C#", "Hlulani", 2015);
        third = new Book("css", "Ralson", 2014);
        fourth = new Book("js", "Hlulani", 2015);

        books = new ArrayList<Book>();
        books.add(first);
        books.add(second);
        books.add(third);
        books.add(fourth);
    }

    @Test
    public void itShouldDisplayAWelcomeMessageOnStart() throws Exception {
        Assert.assertEquals("Welcome to BibliotecaBooks library", biblioteca.greetings());
    }


    @Test
    public void testGetBooksHeaderColumns() throws Exception {
        String header = "" +
                "+------+--------------+-----------------+------------------+" + "\n"
                + "|Number| Title        | Book author     | Year published   |" + "\n"
                + "+------+--------------+-----------------+------------------+";
        Assert.assertEquals(header, biblioteca.getBookListHeader());
    }

    @Test
    public void testReturnLeftAlignerForBodyContent() throws Exception {
        String leftAlignFormat = "| %4s | %12s |%-16s | %-4d %n";

        Assert.assertEquals(leftAlignFormat, biblioteca.getBookContentAligner());
    }

    @Test
    public void testValidMenuOption() throws Exception {
        Assert.assertEquals(biblioteca.listBooks(1), true);
    }

    @Test
    public void displayAllBooks() throws Exception {

        Assert.assertEquals(books, getLibraryBooks());

        for (int i = 0; i < books.size(); i++) {
            Assert.assertEquals(books.get(i).getTitle(), getLibraryBooks().get(i).getTitle());
            Assert.assertEquals(books.get(i).getAuthor(), getLibraryBooks().get(i).getAuthor());
            Assert.assertEquals(books.get(i).getYearPublished(), getLibraryBooks().get(i).getYearPublished());
        }
    }

    @Test
    public void testAddAndGetBookFromBasket() throws Exception {
        Assert.assertEquals(0, getBasketBooks().size());

        biblioteca.addBookToBasket(books.get(0));

        Assert.assertEquals(1, getBasketBooks().size());
    }

    @Test
    public void testCheckOutAndGetBooksFromBasket() throws Exception {
        Assert.assertEquals(1, getBasketBooks().size());

        biblioteca.checkOutBook(1);

        Assert.assertEquals(2,getBasketBooks().size());
    }

    @Test
    public void testReturnABookToLibrary() throws Exception {
        Assert.assertEquals(1, getBasketBooks().size());

        biblioteca.checkOutBook(1);

        Assert.assertEquals(2,getBasketBooks().size());

        int booId = 1;

        biblioteca.returnBook(booId -1);

        Assert.assertEquals(1, getBasketBooks().size());
    }

    @Test
    public void testInvalidOptionSelected() throws Exception {
        Assert.assertEquals("Select a valid option!", biblioteca.invalidOptionSelected());
    }

}
