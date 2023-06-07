package com.technogise.util;

import com.technogise.model.Book;
import com.technogise.model.Library;
import com.technogise.model.User;

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

    public static void addDataToUserList()
    {
        HashMap<User, List<Book>> userList = new HashMap<>();
        userList.put(new User("101","Rishabh"), new ArrayList<Book>());
        userList.put(new User("102","Parag"), new ArrayList<Book>());
        userList.put(new User("103","Shilvi"), new ArrayList<Book>());
        Library.setUserList(userList);
    }
}
