package src.lib.interfaces;

import java.util.List;
import java.util.Scanner;

import src.service.Author;

public interface IAuthorDatabase {

    List<Author> loadAuthors(boolean activePrint);

    List<Author> loadAuthors(String type, String value);

    void addAuthor(Scanner scanner);
}
