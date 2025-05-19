package com.lms;

import com.lms.model.Book;
import com.lms.model.Patron;
import com.lms.service.BookService;
import com.lms.service.LendingService;
import com.lms.service.PatronService;

public class LibraryApplication {
    public static void main(String[] args) {

        BookService bookService = new BookService();
        PatronService patronService = new PatronService();
        LendingService lendingService = new LendingService(bookService, patronService);

        Book b1 = new Book("BookTitle", "Arun", "123", 2005, 2);
        Book b2 = new Book("BookTitle2", "Kumar", "234", 2006, 4);
        Book b3 = new Book("BookTitle3", "Borru", "345", 2007, 8);

        bookService.addBook(b1);
        bookService.addBook(b2);
        bookService.addBook(b3);

        bookService.getAllBooks().forEach(book -> {
            System.out.println("Book: " + book);
        });

        Patron p1 = new Patron("P1", "ArunPatron");
        Patron p2 = new Patron("P2", "KumarPatron");

        patronService.registerPatron(p1);
        patronService.registerPatron(p2);

        System.out.println("Lending Process: Checkout");
        lendingService.checkoutBook("123", "P1");
        System.out.println("Book status after checkout: " + bookService.findBookByIsbn("123"));
        System.out.println("Patron 'P1' borrowing history: " + patronService.getBorrowingHistory("P1"));

        System.out.println("Lending Process: Checkout 2 ");

        lendingService.checkoutBook("234", "P2");
        System.out.println("Book status after checkout: " + bookService.findBookByIsbn("234"));
        System.out.println("Patron 'P2' borrowing history: " + patronService.getBorrowingHistory("P2"));

        System.out.println("Lending Process: Return");
        lendingService.returnBook("123", "P1");
        System.out.println("Return complete.");
        System.out.println("Book status after return: " + bookService.findBookByIsbn("123"));
        System.out.println("Patron 'P1' borrowing history: " + patronService.getBorrowingHistory("P1"));
    }
}