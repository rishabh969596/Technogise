package com.technogise.dao;

import com.technogise.model.Book;
import com.technogise.model.Library;
import com.technogise.model.User;
import com.technogise.util.LibraryUtil;
import org.junit.Test;

import java.util.HashMap;
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

    @Test
    public void getNoBooksWhenBooksAreNotPresent()
    {
        Set<Book> expectedAvailableBooksInLibrary = new HashSet<>();
        expectedAvailableBooksInLibrary.add(new Book("201","Java"));
        Library.setBookList(new HashMap<>());

        LibraryOperations operation = new LibraryOperations();
        Set<Book> getAvailableBooksInLibrary = operation.getAllAvailableBooks();

        assertEquals(0 , getAvailableBooksInLibrary.size());
        assertNotEquals(expectedAvailableBooksInLibrary, getAvailableBooksInLibrary);
    }

    @Test
    public void shouldAddBookToUserIfPresentInLibrary()
    {

        String userId = "101";
        String bookId = "201";
        LibraryUtil.addDataToUserList();
        LibraryUtil.addDataToBookList();

        LibraryOperations operation=new LibraryOperations();
        User user = operation.getUserById(userId);
        Book book= operation.getBookById(bookId);
        int countOfBooksInLibraryBeforeBorrow= operation.getCopiesOfBookPresentinLibrary(book);
        int countOfBooksBeforeBorrow=operation.getBorrowBookListByUser(user).size();
        operation.borrowBookToUser(userId, bookId);
        int countOfBooksAfterBorrow= operation.getBorrowBookListByUser(user).size();
        int countOfBooksInLibraryAfterBorrow =operation.getCopiesOfBookPresentinLibrary(book);

        assertEquals(countOfBooksBeforeBorrow+1, countOfBooksAfterBorrow);
        assertEquals(countOfBooksInLibraryBeforeBorrow-1, countOfBooksInLibraryAfterBorrow);

    }

}
