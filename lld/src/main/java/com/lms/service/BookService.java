package com.lms.service;

import com.lms.model.Book;

import java.util.*;
import java.util.stream.Collectors;

public class BookService {
    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Book with ISBN already exists: " + book.getIsbn());
        }
        books.put(book.getIsbn(), book);
    }

    public void removeBook(String isbn) {
        if (!books.containsKey(isbn)) {
            throw new NoSuchElementException("No book found with ISBN: " + isbn);
        }
        books.remove(isbn);
    }

    public void updateBook(String isbn, Book updatedBook) {
        if (!books.containsKey(isbn)) {
            throw new NoSuchElementException("No book found with ISBN: " + isbn);
        }
        books.put(isbn, updatedBook);
    }

    public Book findBookByIsbn(String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            throw new NoSuchElementException("No book found with ISBN: " + isbn);
        }
        return book;
    }

    public List<Book> searchByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String author) {
        return books.values().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }
}
