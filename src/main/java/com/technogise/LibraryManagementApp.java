package com.technogise;

import com.technogise.dao.LibraryOperations;
import com.technogise.model.Book;
import com.technogise.util.LibraryUtil;
import java.util.Scanner;
import java.util.Set;

public class LibraryManagementApp {
    public static void main(String[] args) {

        int choice;
        Scanner kb = new Scanner(System.in);
        LibraryUtil.addDataToUserList();
        LibraryUtil.addDataToBookList();

        System.out.println("Enter 1 to see Books");
        System.out.println("Enter 2 to borrow Book");
        System.out.println("Enter 3 to close Application");
        LibraryOperations operation = new LibraryOperations();
        do
        {
            System.out.println("Enter your choice");
            choice = kb.nextInt();
            switch(choice)
            {
                case 1:
                    Set<Book> bookList = operation.getAllAvailableBooks();
                    if(bookList.size() == 0)
                        System.out.println("No Books Available");
                    else
                    {
                        for(Book b: bookList)
                        {
                            System.out.println("Book id is: "+ b.getId());
                            System.out.println("Book name is: "+ b.getName());
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Enter user ID");
                    String userId = kb.next();
                    System.out.println("Enter book ID");
                    String bookId = kb.next();
                    System.out.println(operation.borrowBookToUser(userId, bookId));
                    break;

                case 3:
                    System.out.println("Closing application");
                    break;

                default:
                    System.out.println("Enter correct choice");
                    break;
            }
        }
        while(choice != 3);



    }
}