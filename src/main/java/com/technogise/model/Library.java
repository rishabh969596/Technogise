package com.technogise.model;

import java.util.HashMap;

public class Library {

    private static HashMap<Book, Integer> bookList = new HashMap<>();

    public static HashMap<Book, Integer> getBookList() {
        return bookList;
    }
    public static void setBookList(HashMap<Book, Integer> bookList) {
        Library.bookList = bookList;
    }


}
