package src.utils.system;

import java.util.Scanner;

public class AuthorCommandUtils {

    public static boolean Choose(Scanner scanner) {
        System.out.print("Author: ");
        AuthorDatabase authorDatabase = new AuthorDatabase();

        String input = scanner.nextLine();
        String[] parts = input.split("\\s+");
        String command = parts[0];
        switch (command) {
            case "add":
                System.err.println("-------------");
                authorDatabase.addAuthor(scanner);
                return false;
            case "show":
                System.err.println("-------------");
                authorDatabase.loadAuthors(true);
                return false;
            case "search":
                System.err.println("-------------");
                authorDatabase.loadAuthors(scanner);
                return false;
            case "back":
                return true;
            default:
                System.out.println("Invalid command. Please try again.");
                return false;
        }
    }
}
