package src.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import src.lib.interfaces.FileHandler;

public class FileUtils implements FileHandler {
    @Override
    public void createFile(String filename) {
        try {
            if (filename == null) {
                throw new Exception("Please enter file's name!");
            }
            File file = new File(filename);
            boolean createNewFile = file.createNewFile();
            if (createNewFile) {
                System.out.println("File created: " + file.getPath());
            } else {
                System.out.println("File already exists: " + file.getPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeFile(File file, String content) {
        if (!file.exists()) {
            System.err.println("File is not existed!");
            return;
        }

        // // Ensure the .dat extension in the filename
        // String filePath = filename.endsWith(".dat") ? filename : filename + ".dat";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(content);
            writer.newLine(); // Adds a new line after writing the content
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void editFile(Scanner scanner, File file) {
        if (!file.exists()) {
            System.err.println("File is not existed!");
            return;
        }

        StringBuilder contentBuilder = new StringBuilder();
        System.err.println("Text is replaced: ");
        String searchText = scanner.nextLine();
        System.err.println("Replacement Text: ");
        String replacementText = scanner.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Replace the search text with the replacement text in the current line
                contentBuilder.append(line.replaceAll(searchText, replacementText));
                contentBuilder.append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while replacing text in the file.");
            e.printStackTrace();
            return;
        }
        // Write the new content to the file
        try (FileWriter writer = new FileWriter(file.getPath())) {
            writer.write(contentBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile(File file) {
        if (!file.exists()) {
            System.err.println("File is not existed!");
            return;
        }
        // Using try-with-resources to ensure the reader is closed properly
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // Read lines from the file until no more are present
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
