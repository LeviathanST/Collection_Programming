package src.lib.interfaces;

import org.omg.CORBA.Any;

public interface IBookDatabase {
    void loadBooks(boolean activePrint);

    void loadBooks(String type, String condition, Any value);

    void addBook();

    void updateBook();

    void deleteBook();

    void searchBookByTitle();
}
