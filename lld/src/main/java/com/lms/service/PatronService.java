package com.lms.service;

import com.lms.model.Patron;
import java.util.List;

public interface PatronService {
    void registerPatron(Patron patron);

    Patron findPatronById(String id);

    void updatePatronName(String id, String newName);

    void removePatron(String id);

    List<Patron> getAllPatrons();

    String getBorrowingHistory(String id);
}