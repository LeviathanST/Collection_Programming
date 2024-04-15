import java.util.Scanner;

import src.service.SystemBookManagement;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SystemBookManagement system = new SystemBookManagement(scanner);
        system.Init();
    }
}