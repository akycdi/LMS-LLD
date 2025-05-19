package com.lms.service.impl;

import com.lms.model.Book;
import com.lms.model.Patron;
import com.lms.service.LendingService;
import com.lms.service.BookService;
import com.lms.service.PatronService;
import com.lms.strategy.DefaultLendingStrategy;
import com.lms.strategy.LendingStrategy;

import java.util.logging.Logger;

public class LendingServiceImpl implements LendingService {
    private static final Logger logger = Logger.getLogger(LendingServiceImpl.class.getName());
    private final BookService bookService;
    private final PatronService patronService;
    private final LendingStrategy lendingStrategy;

    public LendingServiceImpl(BookService bookService, PatronService patronService) {
        this(bookService, patronService, new DefaultLendingStrategy());
    }

    public LendingServiceImpl(BookService bookService, PatronService patronService, LendingStrategy lendingStrategy) {
        this.bookService = bookService;
        this.patronService = patronService;
        this.lendingStrategy = lendingStrategy;
    }

    @Override
    public void checkoutBook(String isbn, String patronId) {
        Book book = bookService.findBookByIsbn(isbn);
        Patron patron = patronService.findPatronById(patronId);
        lendingStrategy.checkout(book, patron);
        logger.info("Checkout: Book " + isbn + " checked out by Patron " + patronId);
        System.out.println("Book borrowed successfully.");
    }

    @Override
    public void returnBook(String isbn, String patronId) {
        Book book = bookService.findBookByIsbn(isbn);
        Patron patron = patronService.findPatronById(patronId);
        lendingStrategy.returnBook(book, patron);
        logger.info("Return: Book " + isbn + " returned by Patron " + patronId);
        System.out.println("Book returned successfully.");
    }
}