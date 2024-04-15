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

import src.service.Author;

@SuppressWarnings("unchecked")
public class AuthorDatabase {
    private File file = new File("author.dat");
    private List<Author> authors;

    public AuthorDatabase() {
        if (file.exists()) {
            this.authors = loadAuthors(false);
        } else {
            this.authors = new ArrayList<>();
        }

    }

    public List<Author> loadAuthors(boolean activePrint) {
        List<Author> authors = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            authors = (List<Author>) in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        if (activePrint) {
            for (Author author : authors) {
                author.get();
                System.err.println("-------------");
            }
        }
        return authors;
    }

    public void addAuthor(Scanner scanner) {
        System.err.println("Name: ");
        String name = scanner.nextLine();
        System.err.println("ID: ");
        String ID = scanner.nextLine();

        for (Author author : this.authors) {
            if (author.getID().equals(ID)) {
                System.err.println("Author ID is existed!");
                return;
            }
        }

        this.authors.add(new Author(ID, name));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(this.authors);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}