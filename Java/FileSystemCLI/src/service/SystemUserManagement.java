package src.service;

import java.util.Scanner;

import src.lib.interfaces.SystemUserManagementHandler;
import src.utils.system.CommandUtils;

public class SystemUserManagement implements SystemUserManagementHandler {
    private final Scanner scanner;

    public SystemUserManagement(Scanner scanner) {
        this.scanner = scanner;
    }

    public void Init() {
        boolean exit = false;
        System.out.println("\n--- User Management ---");
        System.err.println("Type the command 'rdf command.dat' to have all command!");

        while (!exit) {
            System.out.print("Command: ");
            String input = this.scanner.nextLine(); // Consume the newline
            String[] parts = input.split("\\s+");

            String command = parts[0];
            exit = CommandUtils.Choose(this.scanner, command, parts);
        }

        scanner.close();
    }

}