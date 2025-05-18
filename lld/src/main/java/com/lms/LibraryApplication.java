package com.lms;

import com.lms.entity.Book;
import com.lms.entity.Patron;
import com.lms.service.BookService;
import com.lms.service.PatronService;
import com.lms.service.Implements.BookServiceImplements;
import com.lms.service.Implements.PatronServiceImplements;

public class LibraryApplication {
    public static void main(String[] args) {

        Book book1 = new Book("Test Book 1", "Arun Kumar", 12345, 2001);
        Book book2 = new Book("Test Book 2", "Arun Kumar", 1234, 2001);
        Book book3 = new Book("Test Book 3", "Arun Kumar", 123, 2001);

        BookService bookService = new BookServiceImplements();
        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);

        Patron patron1 = new Patron(1, "Arun", "arun@gmail.com");
        Patron patron2 = new Patron(2, "Kumar", "kumar@gmail.com");

        PatronService patronService = new PatronServiceImplements();
        patronService.addPatron(patron1);
        patronService.addPatron(patron2);

        patronService.recordBorrowing(1, book1);

        System.out.println("Available Books: " + bookService.getAvailableBooks());
        System.out.println("Borrowed Books: " + bookService.getBorrowedBooks());

        System.out.println("Borrowing history for " + patron1.getName() + ": " + patronService.getBorrowingHistory(1));

        patronService.returnBook(1, book1);

        System.out.println("After return - Available Books: " + bookService.getAvailableBooks());
        System.out.println("After return - Borrowed Books: " + bookService.getBorrowedBooks());
    }
}