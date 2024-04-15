package src.lib.interfaces;

public interface IBookManagement {
    void loadBooks();

    void addBook(IBook book);

    void saveBook();

    void deleteBook();

    void updateBook();

    void searchBookByTitle();
}
