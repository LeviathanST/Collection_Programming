package src.utils.system;

import java.io.File;
import java.util.Scanner;

import src.utils.FileUtils;

public class CommandUtils {
    public static boolean Choose(Scanner scanner, String command, String[] parts) {
        FileUtils fileUtils = new FileUtils();
        boolean back = false;

        switch (command) {
            case "book":
                fileUtils.readFile(new File("guide\\bookCommand.dat"));
                while (!back) {
                    back = BookCommandUtils.Choose(scanner);
                }
                return false;
            case "author":
                fileUtils.readFile(new File("guide\\authorCommand.dat"));
                while (!back) {
                    back = AuthorCommandUtils.Choose(scanner);
                }
                return false;
            case "q":
                System.err.println("Exiting....");
                return true;
            default:
                System.out.println("Invalid command. Please try again.");
                return false;
        }
    }
}
