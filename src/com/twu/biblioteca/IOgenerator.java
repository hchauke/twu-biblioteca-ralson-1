package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by hlulani on 2016/09/29.
 */
public class IOgenerator {

    public static int getBookORMovieList(){
        System.out.println("\n(1) List Books  (2) List Movies  (-1) TO EXIT");
        System.out.println("(Selector option)");

        return getUserInput();
    }

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);

        int userChoice = scanner.nextInt();

        return userChoice;
    }
}
