package src.lib.interfaces;

import java.util.List;
import java.util.Scanner;

import src.service.Book;

public interface IBookDatabase {
    List<Book> loadBooks(boolean activePrint);

    void loadBooks(Scanner scanner);

    void addBook(Scanner scanner);

    void updateBook(Scanner scanner);

    void deleteBook(Scanner scanner);
}
