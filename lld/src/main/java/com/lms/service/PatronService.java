package com.lms.service;

import com.lms.model.LendingRecord;
import com.lms.model.Patron;

import java.util.*;

public class PatronService {
    private final Map<String, Patron> patrons = new HashMap<>();

    public void registerPatron(Patron patron) {
        if (patron == null) {
            throw new IllegalArgumentException("Patron cannot be null");
        }
        if (patrons.containsKey(patron.getId())) {
            throw new IllegalArgumentException("Patron already exists with ID: " + patron.getId());
        }
        patrons.put(patron.getId(), patron);
    }

    public Patron findPatronById(String id) {
        Patron patron = patrons.get(id);
        if (patron == null) {
            throw new NoSuchElementException("No patron found with ID: " + id);
        }
        return patron;
    }

    public void updatePatronName(String id, String newName) {
        Patron patron = findPatronById(id);
        patron.setName(newName);
    }

    public void removePatron(String id) {
        if (!patrons.containsKey(id)) {
            throw new NoSuchElementException("No patron found with ID: " + id);
        }
        patrons.remove(id);
    }

    public List<Patron> getAllPatrons() {
        return new ArrayList<>(patrons.values());
    }

    public String getBorrowingHistory(String string) {
        Patron patron = findPatronById(string);
        StringBuilder history = new StringBuilder();
        for (LendingRecord record : patron.getHistory()) {
            history.append(record.toString()).append("\n");
        }
        return history.toString();
    }
}
