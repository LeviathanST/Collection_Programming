package src.lib.interfaces;

import java.io.File;
import java.util.Scanner;

public interface FileHandler {
    void createFile(String filename);

    void writeFile(File file, String content) throws Exception;

    void editFile(Scanner scanner, File file) throws Exception;

    void readFile(File file) throws Exception;
}
