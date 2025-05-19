package com.lms.model;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private final int publicationYear;

    private int totalCopies;
    private int availableCopies;

    public Book(String title, String author, String isbn, int publicationYear, int totalCopies) {
        if (totalCopies <= 0)
            throw new IllegalArgumentException("Total copies must be > 0");
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    public boolean isAvailable() {
        return availableCopies > 0;
    }

    public void borrow() {
        if (!isAvailable())
            throw new IllegalStateException("No copies available to borrow");
        availableCopies--;
    }

    public void returnBook() {
        if (availableCopies >= totalCopies)
            throw new IllegalStateException("All copies are already returned");
        availableCopies++;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setTotalCopies(int totalCopies) {
        if (totalCopies < 0)
            throw new IllegalArgumentException("Total copies must be >= 0");
        this.totalCopies = totalCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        if (availableCopies < 0 || availableCopies > totalCopies)
            throw new IllegalArgumentException("Available copies must be >= 0 and <= total copies");
        this.availableCopies = availableCopies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationYear=" + publicationYear +
                ", totalCopies=" + totalCopies +
                ", availableCopies=" + availableCopies +
                '}';
    }

}