package src.utils.system;

import java.util.Scanner;

public class BookCommandUtils {

    public static boolean Choose(Scanner scanner) {
        System.out.print("Book: ");
        BookDatabase bookDatabase = new BookDatabase();

        String command = scanner.nextLine();
        switch (command.toLowerCase()) {
            case "add":
                bookDatabase.addBook(scanner);
                return false;
            case "show":
                bookDatabase.loadBooks(true);
                return false;
            case "search":
                bookDatabase.loadBooks(scanner);
                return false;
            case "update":
                bookDatabase.updateBook(scanner);
                return false;
            case "delete":
                bookDatabase.deleteBook(scanner);
                return false;
            case "back":
                return true;
            default:
                System.out.println("Invalid command. Please try again.");
                return false;
        }
    }
}
