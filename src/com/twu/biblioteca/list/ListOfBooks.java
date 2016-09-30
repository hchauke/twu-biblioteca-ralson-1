package com.twu.biblioteca.list;

import com.twu.biblioteca.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hlulani on 2016/09/26.
 */
public class ListOfBooks {

   public static List<Book> getBooks(){
       final Book first = new Book("Java", "Ralson", 2014);
       final Book second = new Book("C#", "Hlulani", 2015);
       final Book third = new Book("css", "Ralson", 2014);
       final Book fourth = new Book("js", "Hlulani", 2015);

       List<Book> books = new ArrayList<Book>(){{
           add(first);
           add(second);
           add(third);
           add(fourth);
       }};

       return books;
   }
}
