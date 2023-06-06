package com.technogise.util;

import com.technogise.model.Book;
import com.technogise.model.Library;

import java.util.*;
public class LibraryUtil {

    public static void addDataToBookList()
    {
        HashMap<Book, Integer> bookList = new HashMap<>();
        bookList.put(new Book("201","Java"), 5);
        bookList.put(new Book("202","Scala"), 3);
        bookList.put(new Book("203","Python"), 2);
        bookList.put(new Book("204","Ruby"), 6);
        Library.setBookList(bookList);
    }
}
