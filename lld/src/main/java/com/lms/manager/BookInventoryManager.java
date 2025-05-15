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

    public void addBook(Book book) {
        if (booksByIsbn.containsKey(book.getIsbn())) {
            System.out.println("Already exists: " + book.getIsbn());
        } else {
            booksByIsbn.put(book.getIsbn(), book);
            System.out.println("Book added: " + book.getTitle());
        }
    }

    //update book
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

    //remove book
    public void removeBook(Integer isbn) {
        Book removed = booksByIsbn.remove(isbn);
        if (removed != null) {
            System.out.println("Book removed: " + removed);
        } else {
            System.out.println("Book not found for ISBN: " + isbn);
        }
    }
}
