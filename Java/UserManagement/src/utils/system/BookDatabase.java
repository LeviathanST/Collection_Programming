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

import org.omg.CORBA.Any;

import src.service.Book;

@SuppressWarnings("unchecked")
public class BookDatabase {
    private File file = new File("database\\book.dat");
    private List<Book> books;

    public BookDatabase() {
        if (file.exists()) {
            this.books = loadBooks(false);
        } else {
            this.books = new ArrayList<>();
        }

    }

    public List<Book> loadBooks(boolean activePrint) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
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

    public <T> List<Book> loadAuthors(String type, String condition, T value) {
        List<Book> books = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            books = (List<Book>) in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        for (Book book : books) {
            switch (type) {
                case "price":
                    if (!(value instanceof Integer)) {
                        System.err.println("Type's value is invalid. Please try again!");
                    }
                    Integer priceValue = (Integer) value;

                    if ("greater".equals(condition) && book.getPrice() > priceValue) {
                        book.get();
                    }
                    if ("less-than".equals(condition) && book.getPrice() < priceValue) {
                        book.get();
                    }
                    if ("equals".equals(condition) && book.getPrice() == priceValue) {
                        book.get();
                    }
                    break;
                case "ISBN":
                    break;
                case "title":
                    break;
                case "AuthorID":
                    break;
                default:
                    System.err.println("Condition's type is invalid!. Please try again!");
                    break;
            }
        }
        return books;
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