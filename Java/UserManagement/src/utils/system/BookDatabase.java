package src.utils.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.service.Book;

@SuppressWarnings("unchecked")
public class BookDatabase {
    private File file = new File("book.dat");
    private List<Book> books;

    public BookDatabase() {
        this.file = file;
        if (file.exists()) {
            this.books = loadBooks(false);
        } else {
            this.books = new ArrayList<>();
        }

    }

    public List<Book> loadBooks(boolean activePrint) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.file))) {
            this.books = (List<Book>) in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        if (activePrint) {
            for (Book book : this.books) {
                book.get();
                System.err.println("-------------");
            }
        }
        return this.books;
    }

    public void addBook(Scanner scanner) {
        System.err.println("Title: ");
        String title = scanner.nextLine();
        System.err.println("Price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.err.println("AuthorID: ");
        String AuthorID = scanner.nextLine();
        System.err.println("ISBN: ");
        long ISBN = Integer.parseInt(scanner.nextLine());

        for (Book book : this.books) {
            if (book.getISBN() == ISBN) {
                System.err.println("ISBN is existed!");
                return;
            }
        }

        this.books.add(new Book(ISBN, title, price, AuthorID));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(this.books);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(Scanner scanner) {

    }
}