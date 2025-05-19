package com.lms.service;

import com.lms.model.Book;
import java.util.List;

public interface BookService {
    void addBook(Book book);

    void removeBook(String isbn);

    void updateBook(String isbn, Book updatedBook);

    Book findBookByIsbn(String isbn);

    List<Book> searchByTitle(String title);

    List<Book> searchByAuthor(String author);

    List<Book> getAllBooks();
}