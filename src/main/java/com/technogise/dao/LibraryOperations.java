package com.technogise.dao;

import com.technogise.model.Book;
import com.technogise.model.Library;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LibraryOperations {

    public Set<Book> getAllAvailableBooks()
    {
        HashMap<Book, Integer> bookList = Library.getBookList();
        Set<Book> availableBooks = new HashSet<>();
        Set<Map.Entry<Book,Integer>> entrySet = bookList.entrySet();
        for (Map.Entry<Book,Integer> entry : entrySet)
        {
            if(entry.getValue() > 0)
                availableBooks.add(entry.getKey());
        }
        return availableBooks;
    }
}
