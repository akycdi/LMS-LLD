package com.lms.service.Implements;

import com.lms.entity.Book;
import com.lms.service.BookService;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImplements implements BookService {

    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book getBookByIsbn(Integer isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public void updateBook(Integer isbn, String newTitle, String newAuthor, int newYear) {
        Book book = getBookByIsbn(isbn);
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setYear(newYear);
            System.out.println("Book updated: " + book.getTitle());
        }
    }

    @Override
    public void removeBook(Integer isbn) {
        Book book = getBookByIsbn(isbn);
        if (book != null) {
            books.remove(book);
            System.out.println("Book removed with ISBN: " + isbn);
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book searchBookByTitle(String title) {
        List<Book> found = getBooksByTitle(title);
        return found.isEmpty() ? null : found.get(0);
    }

    @Override
    public Book searchBookByAuthor(String author) {
        List<Book> found = getBooksByAuthor(author);
        return found.isEmpty() ? null : found.get(0);
    }

     @Override
     public List<Book> getAvailableBooks() {
         List<Book> availableBooks = new ArrayList<>();
         for (Book book : books) {
             if (book.isAvailable()) {
                 availableBooks.add(book);
             }
         }
         return availableBooks;
     }
 
     @Override
     public List<Book> getBorrowedBooks() {
         List<Book> borrowedBooks = new ArrayList<>();
         for (Book book : books) {
             if (!book.isAvailable()) {
                 borrowedBooks.add(book);
             }
         }
         return borrowedBooks;
     }

     @Override
     public List<Book> getBooksByPublicationYear(int year) {
            List<Book> booksByYear = new ArrayList<>();
            for (Book book : books) {
                if (book.getYear() == year) {
                    booksByYear.add(book);
                }
            }
            return booksByYear;
     }
}