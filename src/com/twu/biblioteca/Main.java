package com.twu.biblioteca;


import static com.twu.biblioteca.Biblioteca.*;
import static com.twu.biblioteca.IOgenerator.getBookORMovieList;
import static com.twu.biblioteca.IOgenerator.getUserInput;

/**
 * Created by hlulani on 2016/09/26.
 */
public class Main {

    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) throws Exception {

        System.out.println("\n----------------------------------");
        System.out.println(biblioteca.greetings() + "\n----------------------------------");

        while (true) {

            if (getBookORMovieList() == 1) {
                biblioteca.listBooks(getBookORMovieList());
                checkOutBook();
                displayBasketBooks();
                returnABook();

            } else if (getBookORMovieList() == 2) {
                biblioteca.listMovies(getBookORMovieList());
                checkoutMovie();
                displayBasketMoviesContent();

            } else if (getUserInput() == -1) {
                System.exit(0);
                break;
            }
        }
    }

    public static void addBookToBasket() {
        int selector = getUserInput() - 1;

        if (selector == getLibraryBooks().indexOf(getLibraryBooks().get(selector))) {
            biblioteca.addBookToBasket(getLibraryBooks().get(selector));

        } else {
            System.out.println("That book is not available\n");
        }
    }

    public static void addMovieToBasket() {
        int selector = getUserInput() - 1;

        if (selector == getAllMovies().indexOf(getAllMovies().get(selector))) {
            biblioteca.addMovieToBasket(getAllMovies().get(selector));

        } else {
            System.out.println("That Movie is not available\n");
        }
    }

    public static void checkOutBook() {
        System.out.println("\n");
        System.out.println("Check Out Book (enter number corresponding book):");
        addBookToBasket();
    }

    public static void checkoutMovie() {
        System.out.println("\n");
        System.out.println("Check Out Movie (enter number corresponding movie):");
        addMovieToBasket();
    }


    public static void returnABook() {
        int selector = getUserInput() - 1;

        if (selector == getBasketBooks().indexOf(getBasketBooks().get(selector))) {

            biblioteca.returnBook(getBasketBooks().indexOf(getBasketBooks().get(selector)));

        } else {

            System.out.println("That is not a valid book to return");
        }
    }
}
