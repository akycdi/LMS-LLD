package com.lms.manager;

import com.lms.entity.Book;

import java.util.*;

public class BookInventoryManager {

    private final Map<Integer, Book> booksByIsbn = new HashMap<>();

    public List<Book> getAllBooks() {
        return new ArrayList<>(booksByIsbn.values());
    }

    public Book getBookByIsbn(Integer isbn) {
        return booksByIsbn.get(isbn);
    }

    public List<Book> getBooksByTitle(String title) {
        List<Book> books = new ArrayList<>();
        for (Book book : booksByIsbn.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.add(book);
            }
        }
        return books;
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        for (Book book : booksByIsbn.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                books.add(book);
            }
        }
        return books;
    }

    public Book searchBookByTitle(String title) {
        for (Book book : booksByIsbn.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        System.out.println("No book found with title: " + title);
        return null;
    }

    public Book searchBookByAuthor(String author) {
        for (Book book : booksByIsbn.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        System.out.println("No book found with author: " + author);
        return null;
    }

    public void addBook(Book book) {
        if (booksByIsbn.containsKey(book.getIsbn())) {
            System.out.println("Already exists: " + book.getIsbn());
        } else {
            booksByIsbn.put(book.getIsbn(), book);
            System.out.println("Book added: " + book.getTitle());
        }
    }

    public void updateBook(Integer isbn, String newTitle, String newAuthor, int newYear) {
        Book book = booksByIsbn.get(isbn);
        if (book != null) {
            Book updated = new Book(newTitle, newAuthor, isbn, newYear);
            updated.setAvailable(book.isAvailable());
            booksByIsbn.put(isbn, updated);
            System.out.println("Book updated: " + updated);
        } else {
            System.out.println("No book found with ISBN: " + isbn);
        }
    }

    public void removeBook(Integer isbn) {
        Book removed = booksByIsbn.remove(isbn);
        if (removed != null) {
            System.out.println("Book removed: " + removed);
        } else {
            System.out.println("Book not found for ISBN: " + isbn);
        }
    }
}
