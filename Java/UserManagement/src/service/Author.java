package src.service;

import java.io.Serializable;

import src.lib.interfaces.IAuthor;

public class Author implements IAuthor, Serializable {
    private static final long serialVersionUID = 1L;

    private String AuthorID;
    private String name;
    private long serial;

    public Author(String AuthorID, String name) {
        this.serial = serialVersionUID;
        this.AuthorID = AuthorID;
        this.name = name;
    }

    public void get() {
        System.err.println("ID: " + AuthorID);
        System.err.println("Name: " + name);
    }

    public String getID() {
        return this.AuthorID;
    }

    public String getName() {
        return this.name;
    }

}
