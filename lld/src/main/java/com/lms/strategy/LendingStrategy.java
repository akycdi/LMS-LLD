package com.lms.strategy;

import com.lms.model.Book;
import com.lms.model.Patron;

public interface LendingStrategy {
    void checkout(Book book, Patron patron);
    void returnBook(Book book, Patron patron);
}