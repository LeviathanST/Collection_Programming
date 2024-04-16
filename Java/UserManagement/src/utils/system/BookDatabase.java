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

import src.lib.interfaces.IBookDatabase;
import src.service.Author;
import src.service.Book;
import src.utils.FileUtils;

@SuppressWarnings("unchecked")
public class BookDatabase implements IBookDatabase {
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
            System.err.println("-------------");
            for (Book book : this.books) {
                book.get();
            }
        }
        return this.books;
    }

    public void loadBooks(Scanner scanner) {
        FileUtils fileUtils = new FileUtils();
        fileUtils.readFile(new File("guide\\bookSearchCommand.dat"));
        System.err.print("Choose condition's type: ");
        String type = scanner.nextLine();
        System.err.print("Enter condition: ");
        String condition = scanner.nextLine();
        System.err.print("Enter value: ");
        String value = scanner.nextLine();
        System.err.println("-------------");

        List<Book> books = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            books = (List<Book>) in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        for (Book book : books) {
            switch (type.toLowerCase()) {
                case "price":
                    Integer priceValue = Integer.parseInt(value);

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
                    if (book.getISBN() == Long.parseLong(value)) {
                        book.get();
                    }
                    break;
                case "title":

                    if (book.getTitle().contains(value)) {
                        book.get();
                    }
                    break;
                case "authorid":
                    if (book.getAuthorID().contains(value)) {
                        book.get();
                    }
                    break;
                default:
                    System.err.println("Condition's type is invalid!. Please try again!");
                    break;
            }
        }
    }

    public void addBook(Scanner scanner) {
        AuthorDatabase authorDatabase = new AuthorDatabase();

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

        Author existentAuthor = null;
        for (Author author : authorDatabase.loadAuthors(false)) {
            if (author.getID().equals(AuthorID)) {
                existentAuthor = author;
                break;
            }
        }

        if (existentAuthor == null) {
            System.err.println("Author is not existed in list!");
        }

        this.books.add(new Book(ISBN, title, price, AuthorID));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(this.books);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(Scanner scanner) {
        List<Book> newBooks = new ArrayList<>();

        System.err.print("Enter deleted book's ISBN: ");
        long deletedBookISBN = Long.parseLong(scanner.nextLine());
        System.err.print("\nAre you sure? (Y/N) ==>");
        String answer = scanner.nextLine().trim();

        if ("Y".equalsIgnoreCase(answer)) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                books = (List<Book>) in.readObject();

                for (Book book : books) {
                    if (book.getISBN() != deletedBookISBN) {
                        newBooks.add(book);
                    }
                }

                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                    out.writeObject(newBooks);
                } catch (IOException e) {
                    System.err.println("Error writing updated book list back to file.");
                    e.printStackTrace();
                }

            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        } else {
            return;
        }

    }

    public void updateBook(Scanner scanner) {
        System.err.println("Enter book's ISBN: ");
        String isbnInput = scanner.nextLine();
        long isbn = Long.parseLong(isbnInput);

        System.err.println("Which detail would you like to change? (title/price/authorID)");
        String type = scanner.nextLine();

        boolean bookFound = false;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            books = (List<Book>) in.readObject();

            for (Book book : books) {
                if (book.getISBN() == isbn) {
                    switch (type.toLowerCase()) {
                        case "title":
                            System.err.println("Enter new title: ");
                            String newTitle = scanner.nextLine();
                            book.setTitle(newTitle);
                            bookFound = true;
                            break;
                        case "price":
                            System.err.println("Enter new price: ");
                            int newPrice = scanner.nextInt();
                            scanner.nextLine();
                            book.setPrice(newPrice);
                            bookFound = true;
                            break;
                        case "authorid":
                            System.err.println("Enter new Author ID: ");
                            String newAuthorID = scanner.nextLine();
                            book.setAuthorID(newAuthorID);
                            bookFound = true;
                            break;
                        default:
                            System.err.println("Detail type not recognized.");
                            break;
                    }
                    if (bookFound) {
                        break;
                    }
                }
            }

            if (bookFound) {
                // Write the updated list back to the file
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                    out.writeObject(books);
                } catch (IOException e) {
                    System.err.println("Error writing updated book list back to file.");
                    e.printStackTrace();
                }
            } else {
                System.err.println("Book with ISBN " + isbn + " not found.");
            }

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

}