package src.utils.system;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import src.utils.FileUtils;

public class CommandUtils {
    public static boolean Choose(Scanner scanner, String command, String[] parts) {
        FileUtils fileUtils = new FileUtils();
        switch (command) {
            case "crf":
                fileUtils.createFile(parts[1]);
                return false;
            case "wrf":
                if (parts.length > 2) {
                    // Combine all array elements beyond the index 1 for the content
                    String content = String.join(" ", Arrays.copyOfRange(parts, 2, parts.length));
                    fileUtils.writeFile(new File(parts[1]), content);
                } else {
                    System.out.println("Usage: wrf <path/to/filename> <content>");
                }
                return false;
            case "rdf":
                fileUtils.readFile(new File(parts[1]));
                return false;
            case "edf":
                fileUtils.editFile(scanner, new File(parts[1]));
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
