package src.service;

import java.io.Serializable;

import src.lib.interfaces.IBook;

public class Book implements IBook, Serializable {
    private static final long serialVersionUID = 1L;

    private long ISBN;
    private String title;
    private int price;
    private String authorID;
    private long serial;

    public Book(long ISBN, String title, int price, String authorID) {
        this.serial = serialVersionUID;
        this.ISBN = ISBN;
        this.title = title;
        this.price = price;
        this.authorID = authorID;
    }

    public void get() {
        System.err.println("Title: " + this.title);
        System.err.println("Price: " + this.price);
        System.err.println("AuthorID: " + this.authorID);
        System.err.println("ISBN: " + this.ISBN);
        System.err.println("-------------");
    }

    public long getISBN() {
        return this.ISBN;
    }

    public String getAuthorID() {
        return this.authorID;
    }

    public int getPrice() {
        return this.price;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAuthorID(String id) {
        this.authorID = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
