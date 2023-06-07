package com.technogise.dao;

import com.technogise.model.Book;
import com.technogise.model.User;
import com.technogise.model.Library;

import java.util.*;

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

    public User getUserById(String userId)
    {
        HashMap<User, List<Book>> userList = Library.getUserList();
        Set<User> users= userList.keySet();
        for(User user: users)
        {
            if(user.getId().equals(userId))
                return user;
        }
        return null;
    }

    public Book getBookById(String bookId)
    {
        HashMap<Book, Integer> bookList= Library.getBookList();
        Set<Book> books = bookList.keySet();
        for(Book book: books)
        {
            if(book.getId().equals(bookId))
            {
                int bookCount = bookList.get(book);
                if(bookCount>0)
                    return book;
                else
                    return null;
            }
        }
        return null;
    }

    public int getCopiesOfBookPresentinLibrary(Book book)
    {
        return Library.getBookList().get(book);
    }

    public List<Book> getBorrowBookListByUser(User user)
    {
        HashMap<User,List<Book>> userList = Library.getUserList();
        return userList.get(user);
    }

    public void borrowBookToUser(String UserId, String BookId)
    {
        User user=getUserById(UserId);
        Book book=getBookById(BookId);
        if(user != null && book != null)
        {
            List<Book> borrowList = getBorrowBookListByUser(user);
            if(borrowList.size()>=2)
                System.out.println("Already have 2 books");
            else
            {
                borrowList.add(book);
                removeBookCopyfromLibrary(book);
            }
        }
    }

    public void removeBookCopyfromLibrary(Book book)
    {
        HashMap<Book, Integer> bookList= Library.getBookList();
        int bookCount = bookList.get(book);
        bookList.put(book, bookCount-1);
    }

}
