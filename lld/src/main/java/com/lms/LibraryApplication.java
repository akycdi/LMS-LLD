package com.lms;

import com.lms.entity.Book;
import com.lms.service.BookService;
import com.lms.service.Implements.BookServiceImplements;

public class LibraryApplication {
    public static void main(String[] args) {

        Book book1 = new Book("Test Book 1", "Arun Kumar", 12345, 2001);
        Book book2 = new Book("Test Book 2", "Arun Kumar", 1234, 2001);
        Book book3 = new Book("Test Book 3", "Arun Kumar", 123, 2001);

        BookService bookService = new BookServiceImplements();

        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);
    }
}