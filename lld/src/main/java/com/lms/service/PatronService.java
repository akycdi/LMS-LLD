package com.lms.service;

import com.lms.entity.Patron;
import com.lms.entity.Book;
import java.util.List;

public interface PatronService {
    void addPatron(Patron patron);
    void updatePatron(Patron patron);
    Patron getPatronById(int id);
    List<Book> getBorrowingHistory(int patronId);
    void recordBorrowing(int patronId, Book book);
    void returnBook(int patronId, Book book);
    List<Patron> getAllPatrons();
}