package com.lms.service;

import com.lms.model.Book;
import com.lms.model.Patron;

public class LendingService {
    private final BookService bookService;
    private final PatronService patronService;

    public LendingService(BookService bookService, PatronService patronService) {
        this.bookService = bookService;
        this.patronService = patronService;
    }

    public void checkoutBook(String isbn, String patronId) {
        Book book = bookService.findBookByIsbn(isbn);
        Patron patron = patronService.findPatronById(patronId);
        patron.borrowBook(book);
        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(String isbn, String patronId) {
        Book book = bookService.findBookByIsbn(isbn);
        Patron patron = patronService.findPatronById(patronId);
        patron.returnBook(book);
        System.out.println("Book returned successfully.");
    }
}