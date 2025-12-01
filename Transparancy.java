package BarangayManagementSystem;
import java.util.Scanner;
public interface Transparancy {
  
   default void chooseActions(Scanner scan, String transactionType) {
        boolean isRunning = true;
        while (isRunning) {
      System.out.println("=== " + transactionType + " Record ===");
      System.out.println("1 - Add Record");
      System.out.println("2 - Delete Record");
      System.out.println("3 - Edit Record");
      System.out.println("4 - View All Records");
      System.out.println("5 - Exit");   
      int choose = scan.nextInt();
      switch (choose) {
        case 1 -> addRecord(scan);
        case 2 -> deleteRecord(scan);
        case 3 -> editRecord(scan);
        case 4 -> viewAllRecord(scan);
        case 5 -> isRunning = false;
      }
        }
    }
    void addRecord(Scanner scan);
    void deleteRecord(Scanner scan);
    void viewAllRecord(Scanner scan);
    void editRecord(Scanner scan);
}
