package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.list.ListOfBooks.getBooks;
import static com.twu.biblioteca.list.ListOfMovies.getMovies;

public class Biblioteca {

    private static List<Book> booksOnShelf = new ArrayList<Book>();
    private static List<Book> bookOnBasket = new ArrayList<Book>();

    private static List<Movie> moviesOnShelf = new ArrayList<Movie>();
    private static List<Movie> moviesOnBasket = new ArrayList<Movie>();

    public static String greetings() {
        return "Welcome to BibliotecaBooks library";
    }

    public static String getBookListHeader() {
        String header = "" +
                "+------+--------------+-----------------+------------------+" + "\n"
                + "|Number| Title        | Book author     | Year published   |" + "\n"
                + "+------+--------------+-----------------+------------------+";
        return header;
    }

    public static String getMovieListHeader() {

        String header = "" +
                "+------+-----------+-----------+--------------+----------+" + "\n"
                + "|number|Name       | year      | Director     | Ratings  |" + "\n"
                + "+------+-----------+-----------+--------------+----------+";
        return header;
    }

    public static List<Book> getLibraryBooks() {
        booksOnShelf = getBooks();
        return booksOnShelf;
    }

    public static List<Movie> getAllMovies() {
        moviesOnShelf = getMovies();
        return moviesOnShelf;
    }

    public static String getBookContentAligner() {
        return "| %4s | %12s |%-16s | %-4d %n";
    }

    public static String getMovieContentAligner() {
        return "| %-4s | %-9s |%-9s | %-13s | %-5s %n";
    }

    public static void displayBooksContent() {
        String leftAlignFormat = getBookContentAligner();

        List<Book> books = getLibraryBooks();

        for (int i = 0; i < books.size(); i++) {
            System.out.format(leftAlignFormat, books.indexOf(books.get(i)) + 1, books.get(i).getTitle(), books.get(i).getAuthor(), books.get(i).getYearPublished(), "");
        }

    }

    public static void displayMoviesContent() {
        getBookListHeader();
        String leftAlignFormat = getMovieContentAligner();

        List<Movie> movies = getAllMovies();

        for (int i = 0; i < movies.size(); i++) {
            System.out.format(leftAlignFormat, movies.indexOf(movies.get(i)) + 1, movies.get(i).getName(), movies.get(i).getYear(), movies.get(i).getDirector(),movies.get(i).getRating(), "");
        }
    }

    public static void addBookToBasket(Book book) {
        bookOnBasket.add(book);
    }

    public static void addMovieToBasket(Movie movie) {

        moviesOnBasket.add(movie);
    }

    public static void checkOutBook(int bookId) {
        List<Book> libraryBooks = getLibraryBooks();

        for (int i = 0; i < libraryBooks.size(); i++) {
            if (bookId == libraryBooks.indexOf(libraryBooks.get(i))) {
                addBookToBasket(libraryBooks.get(i));
            }
        }
    }

    public static void checkOutMovie(int movieId) {
        List<Movie> libraryMovies = getAllMovies();

        for (int i = 0; i < libraryMovies.size(); i++) {
            if (movieId == libraryMovies.indexOf(libraryMovies.get(i))) {
                addMovieToBasket(libraryMovies.get(i));
            }
        }
    }

    public static List<Book> getBasketBooks() {
        return bookOnBasket;
    }

    public static List<Movie> getBasketMovies() {
        return moviesOnBasket;
    }

    public static void displayBasketBooks() {
        System.out.println("Thank you! Enjoy the book");
        System.out.println(getBookListHeader());
        String leftAlignFormat = getBookContentAligner();
        List<Book> books = getBasketBooks();

        for (int i = 0; i < books.size(); i++) {
            System.out.format(leftAlignFormat, books.indexOf(books.get(i)) + 1, books.get(i).getTitle(), books.get(i).getAuthor(), books.get(i).getYearPublished(), "");
        }

        System.out.println("\n(Return book) specify book number");
    }

    public static void displayBasketMoviesContent(){

        System.out.println("Thank you! Enjoy the movie");
        System.out.println(getMovieListHeader());
        String leftAlignFormat = getMovieContentAligner();
        List<Movie> movies = getBasketMovies();

        for (int i = 0; i < movies.size(); i++) {
            System.out.format(leftAlignFormat, movies.indexOf(movies.get(i)) + 1, movies.get(i).getName(), movies.get(i).getYear(), movies.get(i).getDirector(),movies.get(i).getRating(), "");
        }
    }

    public void returnBook(int bookId) {
        getBasketBooks().remove(getBasketBooks().indexOf(getBasketBooks().get(bookId)));
    }


    public static boolean listBooks(int menuItem) {
        if (menuItem == 1) {

            System.out.println(getBookListHeader());
            displayBooksContent();
        }
        return true;
    }

    public static boolean listMovies(int menuItem) {
        if (menuItem == 2){
            System.out.println(getMovieListHeader());
            displayMoviesContent();
        }
        return true;
    }

    public static String invalidOptionSelected() {
        return "Select a valid option!";
    }
}
