package src.lib.interfaces;

public interface IBookDatabase {
    void loadBooks();
    void addBook();
    void updateBook();
    void deleteBook();
    void searchBookByTitle();
}
