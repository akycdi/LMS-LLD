package com.lms.strategy;

import com.lms.model.Book;
import com.lms.model.Patron;

public class DefaultLendingStrategy implements LendingStrategy {
    @Override
    public void checkout(Book book, Patron patron) {
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is not available for checkout: " + book.getIsbn());
        }
        patron.borrowBook(book);
    }

    @Override
    public void returnBook(Book book, Patron patron) {
        patron.returnBook(book);
    }
}