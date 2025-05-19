package com.lms;

import com.lms.model.Book;
import com.lms.model.Patron;
import com.lms.service.BookService;
import com.lms.service.LendingService;
import com.lms.service.PatronService;
import com.lms.service.impl.BookServiceImpl;
import com.lms.service.impl.LendingServiceImpl;
import com.lms.service.impl.PatronServiceImpl;

import java.util.logging.Logger;

public class LibraryApplication {
    private static final Logger logger = Logger.getLogger(LibraryApplication.class.getName());

    private final BookService bookService;
    private final PatronService patronService;
    private final LendingService lendingService;

    public LibraryApplication(BookService bookService, PatronService patronService, LendingService lendingService) {
        this.bookService = bookService;
        this.patronService = patronService;
        this.lendingService = lendingService;
    }

    public void run() {
        Book b1 = new Book("BookTitle", "Arun", "123", 2005, 2);
        Book b2 = new Book("BookTitle2", "Kumar", "234", 2006, 4);
        Book b3 = new Book("BookTitle3", "Borru", "345", 2007, 8);

        bookService.addBook(b1);
        logger.info("Book added: " + b1);
        bookService.addBook(b2);
        logger.info("Book added: " + b2);
        bookService.addBook(b3);
        logger.info("Book added: " + b3);

        logger.info("All books in inventory:");
        bookService.getAllBooks().forEach(book -> logger.info("Book: " + book));

        Patron p1 = new Patron("P1", "ArunPatron");
        Patron p2 = new Patron("P2", "KumarPatron");

        patronService.registerPatron(p1);
        logger.info("Patron registered: " + p1);
        patronService.registerPatron(p2);
        logger.info("Patron registered: " + p2);

        logger.info(" Lending Process: Checkout");
        logger.info("Lending Process: Checkout");
        lendingService.checkoutBook("123", "P1");
        logger.info("Book status after checkout (ISBN 123): " + bookService.findBookByIsbn("123"));
        logger.info("Patron 'P1' borrowing history:" + patronService.getBorrowingHistory("P1"));

        logger.info("Lending Process: Checkout 2");
        lendingService.checkoutBook("234", "P2");
        logger.info("Book status after checkout (ISBN 234): " + bookService.findBookByIsbn("234"));
        logger.info("Patron 'P2' borrowing history:" + patronService.getBorrowingHistory("P2"));

        logger.info("Lending Process: Return ");
        logger.info("Lending Process: Return");
        lendingService.returnBook("123", "P1");
        logger.info("Return complete.");
        logger.info("Book status after return (ISBN 123): " + bookService.findBookByIsbn("123"));
        logger.info("Patron 'P1' borrowing history:" + patronService.getBorrowingHistory("P1"));
    }

    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        PatronService patronService = new PatronServiceImpl();
        LendingService lendingService = new LendingServiceImpl(bookService, patronService);

        LibraryApplication app = new LibraryApplication(bookService, patronService, lendingService);
        app.run();
    }
}