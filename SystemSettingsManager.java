package BarangayManagementSystem;

import java.util.Scanner;

public class SystemSettingsManager {
      private String barangayName = "Barangay Malinis";
    private String barangayCaptain = "Juan Dela Cruz";
    private String contactNumber = "09123456789";

    public void viewBarangayInformation() {
        System.out.println("\n=== BARANGAY INFORMATION ===");
        System.out.println("Barangay Name: " + barangayName);
        System.out.println("Barangay Captain: " + barangayCaptain);
        System.out.println("Contact Number: " + contactNumber);
    }

    public void updateBarangayInformation(Scanner sc) {
        sc.nextLine();
        System.out.print("Enter new Barangay Name: ");
        barangayName = sc.nextLine();

        System.out.print("Enter new Barangay Captain: ");
        barangayCaptain = sc.nextLine();

        System.out.print("Enter new Contact Number: ");
        contactNumber = sc.nextLine();

        System.out.println("Barangay Information Updated!");
    }

    public void backupSystem() {
        System.out.println("\nCreating system backup...");
        System.out.println("Backup complete! (Simulated)");
    }

    public void restoreSystem() {
        System.out.println("\nRestoring system from backup...");
        System.out.println("System successfully restored! (Simulated)");
    }

}
