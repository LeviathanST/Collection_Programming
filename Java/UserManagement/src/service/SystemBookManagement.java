package src.service;

import java.io.File;
import java.util.Scanner;

import src.lib.interfaces.SystemBookManagementHandler;
import src.utils.FileUtils;
import src.utils.system.CommandUtils;

public class SystemBookManagement implements SystemBookManagementHandler {
    private final Scanner scanner;
    private FileUtils fileUtils = new FileUtils();

    public SystemBookManagement(Scanner scanner) {
        this.scanner = scanner;
    }

    public void Init() {
        boolean exit = false;
        fileUtils.readFile(new File("guide\\lobbyCommand.dat"));

        while (!exit) {
            System.out.print("Your option: ");
            String input = this.scanner.nextLine(); // Consume the newline
            String[] parts = input.split("\\s+");

            String command = parts[0];
            exit = CommandUtils.Choose(this.scanner, command, parts);
        }

        scanner.close();
    }

}