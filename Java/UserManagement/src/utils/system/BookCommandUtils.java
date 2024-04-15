package src.utils.system;

import java.util.Scanner;

public class BookCommandUtils {

    public static boolean Choose(Scanner scanner) {
        System.out.print("Book: ");
        BookDatabase bookDatabase = new BookDatabase();

        String command = scanner.nextLine();
        switch (command) {
            case "add":
                bookDatabase.addBook(scanner);
                return false;
            case "show":
                bookDatabase.loadBooks(true);
                return false;
            case "back":
                return true;
            default:
                System.out.println("Invalid command. Please try again.");
                return false;
        }
    }
}
