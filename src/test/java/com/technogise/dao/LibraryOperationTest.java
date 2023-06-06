package com.technogise.dao;

import com.technogise.model.Book;
import com.technogise.util.LibraryUtil;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class LibraryOperationTest
{
    @Test
    public void getAllAvailableBooksWhenBooksArePresent()
    {
        LibraryUtil.addDataToBookList();
        Set<Book> expectedAvailableBooksInLibrary = new HashSet<>();
        expectedAvailableBooksInLibrary.add(new Book("201","Java"));
        expectedAvailableBooksInLibrary.add(new Book("202","Scala"));
        expectedAvailableBooksInLibrary.add(new Book("203","Python"));
        expectedAvailableBooksInLibrary.add(new Book("204","Ruby"));


        LibraryOperations operation = new LibraryOperations();
        Set<Book> getAvailableBooksInLibrary = operation.getAllAvailableBooks();

        assertEquals(expectedAvailableBooksInLibrary, getAvailableBooksInLibrary);
        expectedAvailableBooksInLibrary.add(new Book("205","Spring"));
        assertNotEquals(expectedAvailableBooksInLibrary, getAvailableBooksInLibrary);
    }
}
