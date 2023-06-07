package com.technogise.model;

import java.util.HashMap;
import java.util.List;

public class Library {

    private static HashMap<Book, Integer> bookList = new HashMap<>();
    private static HashMap<User, List<Book>> userList = new HashMap<>();
    public static HashMap<User, List<Book>> getUserList() {
        return userList;
    }
    public static void setUserList(HashMap<User, List<Book>> userList) {
        Library.userList = userList;
    }

    public static HashMap<Book, Integer> getBookList() {
        return bookList;
    }
    public static void setBookList(HashMap<Book, Integer> bookList) {
        Library.bookList = bookList;
    }


}
