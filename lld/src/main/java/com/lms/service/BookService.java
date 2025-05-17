package com.lms.service;

import com.lms.entity.Book;

import java.util.*;

public interface BookService {

    public void addBook(Book book);

    Book getBookByIsbn(Integer isbn);

    List<Book> getBooksByTitle(String title);

    List<Book> getBooksByAuthor(String author);

    void updateBook(Integer isbn, String newTitle, String newAuthor, int newYear);

    void removeBook(Integer isbn);

    public List<Book> getAllBooks();

    public Book searchBookByTitle(String title);

    public Book searchBookByAuthor(String author);
}
