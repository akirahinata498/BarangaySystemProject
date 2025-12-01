package BarangayManagementSystem;
import java.util.Scanner;
public interface Menu {
    void displayMenu();
    boolean chooseMenu(Scanner scan);
    void processMenu(Scanner scan);
}
