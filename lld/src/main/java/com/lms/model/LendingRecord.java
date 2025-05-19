package com.lms.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LendingRecord {
    private final Book book;
    private final LocalDate checkoutDate;
    private LocalDate returnDate;

    public LendingRecord(Book book) {
        this.book = book;
        this.checkoutDate = LocalDate.now();
    }

    public void markReturned() {
        this.returnDate = LocalDate.now();
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return returnDate != null;
    }

    @Override
    public String toString() {
        return "LendingRecord{" +
                "book=" + book +
                ", checkoutDate=" + checkoutDate +
                ", returnDate=" + returnDate +
                '}';
    }
}