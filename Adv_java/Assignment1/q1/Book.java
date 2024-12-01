package Adv_java.Assignment1.q1;

import java.io.Serializable;

public class Book implements Serializable {
    private int bookId;
    private String bookName;
    private String author;
    private String publication;
    private double price;

    public Book(int bookId, String bookName, String author, String publication, double price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.publication = publication;
        this.price = price;
    }

    public int getBookId() { return bookId; }
    public String getBookName() { return bookName; }
    public String getAuthor() { return author; }
    public String getPublication() { return publication; }
    public double getPrice() { return price; }

    public void setBookName(String bookName) { this.bookName = bookName; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublication(String publication) { this.publication = publication; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return String.format("Book ID: %d, Name: %s, Author: %s, Publication: %s, Price: %.2f",
            bookId, bookName, author, publication, price);
    }
}