package com.lms.service.Implements;

import com.lms.entity.Patron;
import com.lms.entity.Book;
import com.lms.service.PatronService;
import java.util.ArrayList;
import java.util.List;

public class PatronServiceImplements implements PatronService {

    private final List<Patron> patrons = new ArrayList<>();

    @Override
    public void addPatron(Patron patron) {
        if (getPatronById(patron.getId()) != null) {
            System.out.println("Patron with id " + patron.getId() + " already exists.");
            return;
        }
        patrons.add(patron);
        System.out.println("Added patron: " + patron.getName());
    }

    @Override
    public void updatePatron(Patron updatedPatron) {
        for (int i = 0; i < patrons.size(); i++) {
            if (patrons.get(i).getId() == updatedPatron.getId()) {
                patrons.set(i, updatedPatron);
                System.out.println("Updated patron: " + updatedPatron.getName());
                return;
            }
        }
        System.out.println("Patron with id " + updatedPatron.getId() + " not found.");
    }

    @Override
    public Patron getPatronById(int id) {
        for (Patron patron : patrons) {
            if (patron.getId() == id) {
                return patron;
            }
        }
        return null;
    }

    @Override
    public List<Book> getBorrowingHistory(int patronId) {
        Patron patron = getPatronById(patronId);
        return (patron != null) ? patron.getBorrowingHistory() : new ArrayList<>();
    }

    @Override
    public void recordBorrowing(int patronId, Book book) {
        Patron patron = getPatronById(patronId);
        if (patron != null) {
            patron.addBorrowedBook(book);
            System.out.println("Patron " + patron.getName() + " borrowed book: " + book.getTitle());
        } else {
            System.out.println("Patron with id " + patronId + " not found.");
        }
    }

    @Override
    public void returnBook(int patronId, Book book) {
        Patron patron = getPatronById(patronId);
        if (patron != null) {
            patron.removeBorrowedBook(book);
            System.out.println("Patron " + patron.getName() + " returned book: " + book.getTitle());
        } else {
            System.out.println("Patron with id " + patronId + " not found.");
        }
    }

    @Override
    public List<Patron> getAllPatrons() {
        return patrons;
    }
}