package com.lms.entity;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private int id;
    private String name;
    private String email;
    private List<Book> borrowingHistory;

    public Patron(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowingHistory = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Book> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addBorrowedBook(Book book) {
        borrowingHistory.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowingHistory.remove(book);
    }

    @Override
    public String toString() {
        return "Patron [id=" + id + ", name=" + name + ", email=" + email + "]";
    }
}