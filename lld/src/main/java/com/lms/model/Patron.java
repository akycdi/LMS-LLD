package com.lms.model;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private final String id;
    private String name;
    private final List<LendingRecord> history = new ArrayList<>();
    private final List<Book> currentBorrowedBooks = new ArrayList<>();

    public Patron(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void borrowBook(Book book) {
        book.borrow();
        currentBorrowedBooks.add(book);
        history.add(new LendingRecord(book));
    }

    public void returnBook(Book book) {
        if (!currentBorrowedBooks.contains(book))
            throw new IllegalArgumentException("Book not currently borrowed by patron");
        book.returnBook();
        currentBorrowedBooks.remove(book);
        for (LendingRecord record : history) {
            if (record.getBook().equals(book) && record.getReturnDate() == null) {
                record.markReturned();
                break;
            }
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LendingRecord> getHistory() {
        return history;
    }

    public List<Book> getCurrentBorrowedBooks() {
        return currentBorrowedBooks;
    }

    @Override
    public String toString() {
        return "Patron{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}