package com.lms.service.impl;

import com.lms.model.Book;
import com.lms.service.BookService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.logging.Logger;

public class BookServiceImpl implements BookService {
    private static final Logger logger = Logger.getLogger(BookServiceImpl.class.getName());
    private final Map<String, Book> books = new HashMap<>();

    @Override
    public void addBook(Book book) {
        if (book == null)
            throw new IllegalArgumentException("Book cannot be null");
        if (books.containsKey(book.getIsbn()))
            throw new IllegalArgumentException("Book with ISBN already exists: " + book.getIsbn());
        books.put(book.getIsbn(), book);
        logger.info("Book added: " + book);
    }

    @Override
    public void removeBook(String isbn) {
        if (!books.containsKey(isbn))
            throw new NoSuchElementException("No book found with ISBN: " + isbn);
        Book removed = books.remove(isbn);
        logger.info("Book removed: " + removed);
    }

    @Override
    public void updateBook(String isbn, Book updatedBook) {
        if (!books.containsKey(isbn))
            throw new NoSuchElementException("No book found with ISBN: " + isbn);
        books.put(isbn, updatedBook);
        logger.info("Book updated: " + updatedBook);
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        Book book = books.get(isbn);
        if (book == null)
            throw new NoSuchElementException("No book found with ISBN: " + isbn);
        return book;
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return books.values().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }
}