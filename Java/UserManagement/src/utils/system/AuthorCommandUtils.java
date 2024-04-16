package src.utils.system;

import java.io.File;
import java.util.Scanner;

import src.utils.FileUtils;

public class AuthorCommandUtils {

    public static boolean Choose(Scanner scanner) {
        System.out.print("Author: ");
        AuthorDatabase authorDatabase = new AuthorDatabase();

        String input = scanner.nextLine();
        String[] parts = input.split("\\s+");
        String command = parts[0];
        switch (command) {
            case "add":
                authorDatabase.addAuthor(scanner);
                return false;
            case "show":
                authorDatabase.loadAuthors(true);
                return false;
            case "search":
                FileUtils fileUtils = new FileUtils();
                fileUtils.readFile(new File("guide\\authorSearchCommand.dat"));
                System.err.print("Choose condition's type: ");
                String type = scanner.nextLine();
                System.err.print("Enter value: ");
                String value = scanner.nextLine();
                System.err.println("-------------");

                authorDatabase.loadAuthors(type, value);
            case "back":
                return true;
            default:
                System.out.println("Invalid command. Please try again.");
                return false;
        }
    }
}
