import java.util.Scanner;

import src.service.SystemUserManagement;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SystemUserManagement system = new SystemUserManagement(scanner);
        system.Init();
    }
}