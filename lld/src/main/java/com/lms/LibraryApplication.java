package com.lms;

import com.lms.entity.Book;
import com.lms.manager.BookInventoryManager;

public class LibraryApplication {
    public static void main(String[] args) {

        Book book1 = new Book("Test Book 1", "Arun Kumar", 12345, 2001);
        Book book2 = new Book("Test Book 2", "Arun Kumar", 1234, 2001);
        Book book3= new Book("Test Book 3", "Arun Kumar", 123, 2001);

        // System.out.println(book.getTitle());

        BookInventoryManager bookManager = new BookInventoryManager();
        bookManager.addBook(book1);
        bookManager.addBook(book2);
        bookManager.addBook(book3);


        System.out.println(bookManager.getAllBooks().size());
        System.out.println(bookManager.getBookByIsbn(12345).getTitle());
        // System.out.println( "Hello World!" );
    }
}
